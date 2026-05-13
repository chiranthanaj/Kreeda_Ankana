package com.example.kreedaankana.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kreedaankana.viewmodel.AppUiState

@Composable
fun ScoreScreen(
    state: AppUiState,
    onPost: (String, String, String, String, String, String) -> Unit
) {
    var showPost by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Score Wall",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { showPost = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Post match result")
        }

        Spacer(Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (state.localScores.isEmpty()) {
                item {
                    Card {
                        Column(Modifier.padding(12.dp)) {
                            Text("No scores posted yet.")
                        }
                    }
                }
            } else {
                items(state.localScores, key = { it.id }) { score ->
                    val winner = if (score.scoreA >= score.scoreB) score.teamA else score.teamB
                    Card {
                        Column(Modifier.padding(12.dp)) {
                            Text("${score.sport} • ${score.ground}", fontWeight = FontWeight.Bold)
                            Text("${score.teamA} ${score.scoreA}  vs  ${score.scoreB} ${score.teamB}")
                            Text("Winner: $winner", style = MaterialTheme.typography.labelMedium)
                            Text(score.dateLabel, style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }
    }

    if (showPost) {
        var sport by remember { mutableStateOf("Cricket") }
        var teamA by remember { mutableStateOf("") }
        var teamB by remember { mutableStateOf("") }
        var scoreA by remember { mutableStateOf("") }
        var scoreB by remember { mutableStateOf("") }
        var ground by remember { mutableStateOf(state.currentGround) }

        AlertDialog(
            onDismissRequest = { showPost = false },
            title = { Text("Post result") },
            text = {
                Column {
                    OutlinedTextField(sport, { sport = it }, label = { Text("Sport") })
                    OutlinedTextField(teamA, { teamA = it }, label = { Text("Team A") })
                    OutlinedTextField(teamB, { teamB = it }, label = { Text("Team B") })
                    OutlinedTextField(scoreA, { scoreA = it }, label = { Text("Score A") })
                    OutlinedTextField(scoreB, { scoreB = it }, label = { Text("Score B") })
                    OutlinedTextField(ground, { ground = it }, label = { Text("Ground") })
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onPost(sport, teamA, teamB, scoreA, scoreB, ground)
                    showPost = false
                }) { Text("Post") }
            },
            dismissButton = { TextButton(onClick = { showPost = false }) { Text("Cancel") } }
        )
    }
}