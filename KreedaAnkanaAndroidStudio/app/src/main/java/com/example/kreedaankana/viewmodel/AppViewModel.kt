package com.example.kreedaankana.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kreedaankana.data.model.Booking
import com.example.kreedaankana.data.model.Challenge
import com.example.kreedaankana.data.model.Reply
import com.example.kreedaankana.data.model.ScoreMatch
import com.example.kreedaankana.data.model.TeamProfile
import com.example.kreedaankana.data.repository.AppRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.UUID

data class AppUiState(
    val loggedIn: Boolean = false,
    val email: String? = null,
    val loading: Boolean = false,
    val error: String? = null,
    val currentGround: String = "Kodipalya Ground",
    val selectedDate: LocalDate = LocalDate.now(),
    val team: TeamProfile = TeamProfile(),
    val bookings: List<Booking> = emptyList(),
    val challenges: List<Challenge> = emptyList(),
    val localScores: List<com.example.kreedaankana.data.local.ScoreEntity> = emptyList()
)

class AppViewModel(
    private val repo: AppRepository
) : ViewModel() {

    private val _ui = MutableStateFlow(AppUiState())
    val ui = _ui.asStateFlow()

    private val groundList = listOf("Kodipalya Ground", "Hemmige Maidan", "Bannur Field", "T. Narasipur Park")

    init {
        viewModelScope.launch {
            val loggedIn = repo.currentUid() != null
            _ui.update { it.copy(loggedIn = loggedIn, email = repo.currentEmail()) }
            if (loggedIn) {
                repo.startUserSync()
                repo.startGroundListener(_ui.value.currentGround)
                repo.startChallengeListener()
                repo.startScoreListener()
            }
            repo.team.collect { team ->
                _ui.update { it.copy(team = team ?: TeamProfile()) }
            }
        }

        viewModelScope.launch {
            repo.bookings.collect { items -> _ui.update { it.copy(bookings = items) } }
        }
        viewModelScope.launch {
            repo.challenges.collect { items -> _ui.update { it.copy(challenges = items) } }
        }
        viewModelScope.launch {
            repo.localScores.collect { items -> _ui.update { it.copy(localScores = items) } }
        }
    }

    fun register(email: String, password: String) = viewModelScope.launch {
        runCatching {
            _ui.update { it.copy(loading = true, error = null) }
            repo.register(email, password)
            repo.startUserSync()
            repo.startGroundListener(_ui.value.currentGround)
            repo.startChallengeListener()
            repo.startScoreListener()
            _ui.update { it.copy(loggedIn = true, email = email, loading = false) }
        }.onFailure {
            _ui.update { state -> state.copy(loading = false, error = it.message ?: "Registration failed") }
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        runCatching {
            _ui.update { it.copy(loading = true, error = null) }
            repo.login(email, password)
            repo.startUserSync()
            repo.startGroundListener(_ui.value.currentGround)
            repo.startChallengeListener()
            repo.startScoreListener()
            _ui.update { it.copy(loggedIn = true, email = email, loading = false) }
        }.onFailure {
            _ui.update { state -> state.copy(loading = false, error = it.message ?: "Login failed") }
        }
    }

    fun signOut() = viewModelScope.launch {
        repo.signOut()
        repo.clearListeners()
        _ui.value = AppUiState()
    }

    fun selectGround(ground: String) {
        _ui.update { it.copy(currentGround = ground) }
        repo.startGroundListener(ground)
    }

    fun selectDate(date: LocalDate) {
        _ui.update { it.copy(selectedDate = date) }
    }

    fun saveTeam(teamName: String, village: String, sportsCsv: String) = viewModelScope.launch {
        val team = _ui.value.team.copy(
            uid = repo.currentUid().orEmpty(),
            teamName = teamName,
            village = village,
            sports = sportsCsv.split(",").map { it.trim() }.filter { it.isNotBlank() }.ifEmpty { listOf("Cricket") }
        )
        repo.saveTeam(team)
    }

    fun bookSlot(slot: String, sport: String, teamName: String) = viewModelScope.launch {
        runCatching {
            val dateKey = _ui.value.selectedDate.format(DateTimeFormatter.ISO_DATE)
            repo.bookSlot(
                Booking(
                    id = "",
                    ground = _ui.value.currentGround,
                    dateKey = dateKey,
                    slot = slot,
                    sport = sport,
                    teamName = teamName,
                    uid = repo.currentUid().orEmpty(),
                    createdAt = System.currentTimeMillis()
                )
            )
        }.onSuccess {
            repo.startGroundListener(_ui.value.currentGround)
        }.onFailure {
            _ui.update { state -> state.copy(error = it.message ?: "Booking failed") }
        }
    }

    fun postChallenge(sport: String, msg: String, time: String, ground: String) = viewModelScope.launch {
        val team = _ui.value.team
        repo.postChallenge(
            Challenge(
                id = UUID.randomUUID().toString(),
                team = team.teamName,
                village = team.village,
                sport = sport,
                msg = msg,
                time = time,
                ground = ground,
                createdAt = System.currentTimeMillis()
            )
        )
    }

    fun replyToChallenge(challengeId: String, reply: String) = viewModelScope.launch {
        repo.replyToChallenge(challengeId, Reply(team = _ui.value.team.teamName, text = reply))
    }

    fun postScore(sport: String, teamA: String, teamB: String, scoreA: String, scoreB: String, ground: String) = viewModelScope.launch {
        val a = scoreA.toIntOrNull() ?: return@launch
        val b = scoreB.toIntOrNull() ?: return@launch
        val now = LocalDate.now()
        val match = ScoreMatch(
            id = UUID.randomUUID().toString(),
            sport = sport,
            teamA = teamA,
            teamB = teamB,
            scoreA = a,
            scoreB = b,
            ground = ground,
            dateLabel = now.format(DateTimeFormatter.ofPattern("d MMM yyyy")),
            createdAt = System.currentTimeMillis()
        )
        repo.postScore(match)
    }

    fun retryListeners() {
        repo.startGroundListener(_ui.value.currentGround)
        repo.startChallengeListener()
        repo.startScoreListener()
    }
}

class AppViewModelFactory(
    private val repo: AppRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppViewModel(repo) as T
    }
}
