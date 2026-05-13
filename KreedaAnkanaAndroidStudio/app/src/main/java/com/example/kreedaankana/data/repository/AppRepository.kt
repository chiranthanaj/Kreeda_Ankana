package com.example.kreedaankana.data.repository

import com.example.kreedaankana.data.local.ScoreDao
import com.example.kreedaankana.data.local.ScoreEntity
import com.example.kreedaankana.data.model.Booking
import com.example.kreedaankana.data.model.Challenge
import com.example.kreedaankana.data.model.Reply
import com.example.kreedaankana.data.model.ScoreMatch
import com.example.kreedaankana.data.model.TeamProfile
import com.example.kreedaankana.data.remote.FirebaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class AppRepository(
    private val firebase: FirebaseRepository,
    private val scoreDao: ScoreDao
) {
    private val _team = MutableStateFlow<TeamProfile?>(null)
    val team = _team.asStateFlow()

    private val _bookings = MutableStateFlow<List<Booking>>(emptyList())
    val bookings = _bookings.asStateFlow()

    private val _challenges = MutableStateFlow<List<Challenge>>(emptyList())
    val challenges = _challenges.asStateFlow()

    private val _scores = MutableStateFlow<List<ScoreMatch>>(emptyList())
    val scores = _scores.asStateFlow()

    val localScores: Flow<List<ScoreEntity>> = scoreDao.observeScores()

    private var teamListener: com.google.firebase.firestore.ListenerRegistration? = null
    private var bookingListener: com.google.firebase.firestore.ListenerRegistration? = null
    private var challengeListener: com.google.firebase.firestore.ListenerRegistration? = null
    private var scoreListener: com.google.firebase.firestore.ListenerRegistration? = null

    fun currentUid() = firebase.currentUid()
    fun currentEmail() = firebase.currentEmail()

    suspend fun register(email: String, password: String) = firebase.register(email, password)
    suspend fun login(email: String, password: String) = firebase.login(email, password)
    fun signOut() = firebase.signOut()

    suspend fun startUserSync() {
        val uid = currentUid() ?: return
        teamListener?.remove()
        teamListener = firebase.observeTeam(uid) { _team.value = it }
        if (_team.value == null) {
            _team.value = firebase.loadTeam(uid) ?: TeamProfile(uid = uid)
        }
    }

    suspend fun saveTeam(team: TeamProfile) {
        firebase.saveTeam(team)
        _team.value = team
    }

    fun startGroundListener(ground: String) {
        bookingListener?.remove()
        bookingListener = firebase.observeBookings(ground) { _bookings.value = it }
    }

    fun startChallengeListener() {
        challengeListener?.remove()
        challengeListener = firebase.observeChallenges { _challenges.value = it }
    }

    fun startScoreListener() {
        scoreListener?.remove()
        scoreListener = firebase.observeScores { remote ->
            _scores.value = remote
        }
    }

    suspend fun refreshLocalScores() {
        // Not needed because Room is the source of truth for the score wall.
    }

    suspend fun bookSlot(booking: Booking) = firebase.bookSlot(booking)

    suspend fun postChallenge(challenge: Challenge) = firebase.postChallenge(challenge)

    suspend fun replyToChallenge(challengeId: String, reply: Reply) =
        firebase.replyToChallenge(challengeId, reply)

    suspend fun postScore(match: ScoreMatch) = withContext(Dispatchers.IO) {
        // Insert locally first so the score wall updates immediately.
        scoreDao.upsert(
            ScoreEntity(
                id = match.id.ifBlank { "local_${System.currentTimeMillis()}" },
                sport = match.sport,
                teamA = match.teamA,
                teamB = match.teamB,
                scoreA = match.scoreA,
                scoreB = match.scoreB,
                ground = match.ground,
                dateLabel = match.dateLabel,
                createdAt = match.createdAt
            )
        )
        firebase.postScore(match)
    }

    suspend fun saveScoreLocal(match: ScoreMatch) = withContext(Dispatchers.IO) {
        scoreDao.upsert(
            ScoreEntity(
                id = match.id,
                sport = match.sport,
                teamA = match.teamA,
                teamB = match.teamB,
                scoreA = match.scoreA,
                scoreB = match.scoreB,
                ground = match.ground,
                dateLabel = match.dateLabel,
                createdAt = match.createdAt
            )
        )
    }

    fun clearListeners() {
        teamListener?.remove()
        bookingListener?.remove()
        challengeListener?.remove()
        scoreListener?.remove()
    }
}