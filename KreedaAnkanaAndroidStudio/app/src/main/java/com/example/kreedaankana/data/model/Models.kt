package com.example.kreedaankana.data.model

data class TeamProfile(
    val uid: String = "",
    val teamName: String = "Village Tigers",
    val village: String = "Kodipalya, Mysuru",
    val sports: List<String> = listOf("Cricket", "Volleyball"),
    val matches: Int = 12,
    val wins: Int = 8,
    val slotsUsed: Int = 5
)

data class Booking(
    val id: String = "",
    val ground: String = "",
    val dateKey: String = "",
    val slot: String = "",
    val sport: String = "",
    val teamName: String = "",
    val uid: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

data class Reply(
    val team: String = "",
    val text: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

data class Challenge(
    val id: String = "",
    val team: String = "",
    val village: String = "",
    val sport: String = "",
    val msg: String = "",
    val time: String = "",
    val ground: String = "",
    val replies: List<Reply> = emptyList(),
    val createdAt: Long = System.currentTimeMillis(),
    val accepted: Boolean = false
)

data class ScoreMatch(
    val id: String = "",
    val sport: String = "",
    val teamA: String = "",
    val teamB: String = "",
    val scoreA: Int = 0,
    val scoreB: Int = 0,
    val ground: String = "",
    val dateLabel: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
