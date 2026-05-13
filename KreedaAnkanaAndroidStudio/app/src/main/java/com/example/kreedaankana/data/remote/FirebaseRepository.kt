package com.example.kreedaankana.data.remote

import com.example.kreedaankana.data.model.Booking
import com.example.kreedaankana.data.model.Challenge
import com.example.kreedaankana.data.model.Reply
import com.example.kreedaankana.data.model.ScoreMatch
import com.example.kreedaankana.data.model.TeamProfile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await

class FirebaseRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    private val teams = db.collection("teams")
    private val bookings = db.collection("bookings")
    private val challenges = db.collection("challenges")
    private val scores = db.collection("scores")

    fun currentUid(): String? = auth.currentUser?.uid
    fun currentEmail(): String? = auth.currentUser?.email

    suspend fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).await()
        currentUid()?.let { uid ->
            teams.document(uid).set(
                TeamProfile(uid = uid).toMap()
            ).await()
        }
    }

    suspend fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    fun signOut() = auth.signOut()

    suspend fun loadTeam(uid: String): TeamProfile? {
        val snap = teams.document(uid).get().await()
        return snap.toTeamProfile()
    }

    suspend fun saveTeam(team: TeamProfile) {
        teams.document(team.uid).set(team.toMap()).await()
    }

    fun observeTeam(uid: String, onChange: (TeamProfile) -> Unit): ListenerRegistration {
        return teams.document(uid).addSnapshotListener { snap, _ ->
            snap?.toTeamProfile()?.let(onChange)
        }
    }

    fun observeBookings(ground: String, onChange: (List<Booking>) -> Unit): ListenerRegistration {
        return bookings
            .whereEqualTo("ground", ground)
            .addSnapshotListener { snap, _ ->
                val list = snap?.documents
                    ?.mapNotNull { it.toBooking() }
                    ?.sortedWith(compareBy<Booking> { it.dateKey }.thenBy { it.slot })
                    .orEmpty()
                onChange(list)
            }
    }

    suspend fun bookSlot(booking: Booking) {
        val id = bookingId(booking.ground, booking.dateKey, booking.slot)
        db.runTransaction { tx ->
            val doc = bookings.document(id)
            val existing = tx.get(doc)
            if (existing.exists()) {
                throw IllegalStateException("Slot already booked")
            }
            tx.set(doc, booking.copy(id = id).toMap())
        }.await()
    }

    fun observeChallenges(onChange: (List<Challenge>) -> Unit): ListenerRegistration {
        return challenges.orderBy("createdAt", Query.Direction.DESCENDING)
            .addSnapshotListener { snap, _ ->
                val list = snap?.documents?.mapNotNull { it.toChallenge() }.orEmpty()
                onChange(list)
            }
    }

    suspend fun postChallenge(challenge: Challenge): String {
        val ref = challenges.document()
        ref.set(challenge.copy(id = ref.id).toMap()).await()
        return ref.id
    }

    suspend fun replyToChallenge(challengeId: String, reply: Reply) {
        challenges.document(challengeId)
            .update("replies", FieldValue.arrayUnion(reply.toMap()))
            .await()
    }

    fun observeScores(onChange: (List<ScoreMatch>) -> Unit): ListenerRegistration {
        return scores.orderBy("createdAt", Query.Direction.DESCENDING)
            .addSnapshotListener { snap, _ ->
                val list = snap?.documents?.mapNotNull { it.toScoreMatch() }.orEmpty()
                onChange(list)
            }
    }

    suspend fun postScore(match: ScoreMatch): String {
        val ref = scores.document()
        ref.set(match.copy(id = ref.id).toMap()).await()
        return ref.id
    }

    private fun bookingId(ground: String, dateKey: String, slot: String): String =
        "${ground}_${dateKey}_${slot}".replace(" ", "_")

    private fun TeamProfile.toMap(): Map<String, Any> = mapOf(
        "uid" to uid,
        "teamName" to teamName,
        "village" to village,
        "sports" to sports,
        "matches" to matches,
        "wins" to wins,
        "slotsUsed" to slotsUsed
    )

    private fun Booking.toMap(): Map<String, Any> = mapOf(
        "id" to id,
        "ground" to ground,
        "dateKey" to dateKey,
        "slot" to slot,
        "sport" to sport,
        "teamName" to teamName,
        "uid" to uid,
        "createdAt" to createdAt
    )

    private fun Challenge.toMap(): Map<String, Any> = mapOf(
        "id" to id,
        "team" to team,
        "village" to village,
        "sport" to sport,
        "msg" to msg,
        "time" to time,
        "ground" to ground,
        "replies" to replies.map { it.toMap() },
        "createdAt" to createdAt,
        "accepted" to accepted
    )

    private fun Reply.toMap(): Map<String, Any> = mapOf(
        "team" to team,
        "text" to text,
        "createdAt" to createdAt
    )

    private fun ScoreMatch.toMap(): Map<String, Any> = mapOf(
        "id" to id,
        "sport" to sport,
        "teamA" to teamA,
        "teamB" to teamB,
        "scoreA" to scoreA,
        "scoreB" to scoreB,
        "ground" to ground,
        "dateLabel" to dateLabel,
        "createdAt" to createdAt
    )

    private fun com.google.firebase.firestore.DocumentSnapshot.toTeamProfile(): TeamProfile? {
        if (!exists()) return null
        return TeamProfile(
            uid = getString("uid") ?: "",
            teamName = getString("teamName") ?: "Village Tigers",
            village = getString("village") ?: "Kodipalya, Mysuru",
            sports = (get("sports") as? List<*>)?.mapNotNull { it as? String } ?: listOf("Cricket", "Volleyball"),
            matches = (getLong("matches") ?: 0L).toInt(),
            wins = (getLong("wins") ?: 0L).toInt(),
            slotsUsed = (getLong("slotsUsed") ?: 0L).toInt()
        )
    }

    private fun com.google.firebase.firestore.DocumentSnapshot.toBooking(): Booking? {
        return Booking(
            id = getString("id") ?: id,
            ground = getString("ground") ?: return null,
            dateKey = getString("dateKey") ?: return null,
            slot = getString("slot") ?: return null,
            sport = getString("sport") ?: "Cricket",
            teamName = getString("teamName") ?: "Unknown",
            uid = getString("uid") ?: "",
            createdAt = getLong("createdAt") ?: System.currentTimeMillis()
        )
    }

    private fun com.google.firebase.firestore.DocumentSnapshot.toChallenge(): Challenge? {
        val replyList = (get("replies") as? List<*>)?.mapNotNull { item ->
            val map = item as? Map<*, *> ?: return@mapNotNull null
            Reply(
                team = map["team"] as? String ?: "",
                text = map["text"] as? String ?: "",
                createdAt = when (val value = map["createdAt"]) {
                    is Long -> value
                    is Double -> value.toLong()
                    is Int -> value.toLong()
                    else -> System.currentTimeMillis()
                }
            )
        }.orEmpty()

        return Challenge(
            id = getString("id") ?: id,
            team = getString("team") ?: return null,
            village = getString("village") ?: "",
            sport = getString("sport") ?: "Cricket",
            msg = getString("msg") ?: "",
            time = getString("time") ?: "",
            ground = getString("ground") ?: "",
            replies = replyList,
            createdAt = getLong("createdAt") ?: System.currentTimeMillis(),
            accepted = getBoolean("accepted") ?: false
        )
    }

    private fun com.google.firebase.firestore.DocumentSnapshot.toScoreMatch(): ScoreMatch? {
        return ScoreMatch(
            id = getString("id") ?: id,
            sport = getString("sport") ?: return null,
            teamA = getString("teamA") ?: "",
            teamB = getString("teamB") ?: "",
            scoreA = (getLong("scoreA") ?: 0L).toInt(),
            scoreB = (getLong("scoreB") ?: 0L).toInt(),
            ground = getString("ground") ?: "",
            dateLabel = getString("dateLabel") ?: "",
            createdAt = getLong("createdAt") ?: System.currentTimeMillis()
        )
    }
}