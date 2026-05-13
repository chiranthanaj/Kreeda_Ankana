package com.example.kreedaankana.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kreedaankana.viewmodel.AppUiState

@Composable
fun ChallengeScreen(
    state: AppUiState,
    onPost: (String, String, String, String) -> Unit,
    onReply: (String, String) -> Unit
) {
    var showPost by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Challenge Board",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { showPost = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Post a challenge")
        }

        Spacer(Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(state.challenges, key = { it.id }) { challenge ->
                var replyText by rememberSaveable(challenge.id) { mutableStateOf("") }

                Card {
                    Column(Modifier.padding(12.dp)) {
                        Text(challenge.team, fontWeight = FontWeight.Bold)
                        Text("${challenge.village} • ${challenge.sport}")
                        Spacer(Modifier.height(6.dp))
                        Text(challenge.msg)
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "${challenge.time} • ${challenge.ground}",
                            style = MaterialTheme.typography.labelMedium
                        )

                        if (challenge.replies.isNotEmpty()) {
                            Spacer(Modifier.height(10.dp))
                            Text("Replies", fontWeight = FontWeight.SemiBold)
                            Spacer(Modifier.height(4.dp))
                            challenge.replies.forEach { reply ->
                                Text("• ${reply.team}: ${reply.text}")
                            }
                        }

                        Spacer(Modifier.height(10.dp))
                        OutlinedTextField(
                            value = replyText,
                            onValueChange = { replyText = it },
                            label = { Text("Reply / accept") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(Modifier.height(6.dp))
                        Button(
                            onClick = {
                                val msg = replyText.trim()
                                if (msg.isNotEmpty()) {
                                    onReply(challenge.id, msg)
                                    replyText = ""
                                }
                            },
                            enabled = replyText.isNotBlank()
                        ) { Text("Send reply") }
                    }
                }
            }
        }
    }

    if (showPost) {
        var sport by remember { mutableStateOf("Cricket") }
        var msg by remember { mutableStateOf("") }
        var time by remember { mutableStateOf("") }
        var ground by remember { mutableStateOf(state.currentGround) }

        AlertDialog(
            onDismissRequest = { showPost = false },
            title = { Text("Post challenge") },
            text = {
                Column {
                    OutlinedTextField(sport, { sport = it }, label = { Text("Sport") })
                    OutlinedTextField(msg, { msg = it }, label = { Text("Message") })
                    OutlinedTextField(time, { time = it }, label = { Text("Preferred time") })
                    OutlinedTextField(ground, { ground = it }, label = { Text("Ground") })
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onPost(sport, msg, time, ground)
                    showPost = false
                }) { Text("Post") }
            },
            dismissButton = { TextButton(onClick = { showPost = false }) { Text("Cancel") } }
        )
    }
}