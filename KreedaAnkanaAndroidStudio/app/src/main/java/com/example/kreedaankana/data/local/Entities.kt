package com.example.kreedaankana.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_entries")
data class ScoreEntity(
    @PrimaryKey val id: String,
    val sport: String,
    val teamA: String,
    val teamB: String,
    val scoreA: Int,
    val scoreB: Int,
    val ground: String,
    val dateLabel: String,
    val createdAt: Long
)
