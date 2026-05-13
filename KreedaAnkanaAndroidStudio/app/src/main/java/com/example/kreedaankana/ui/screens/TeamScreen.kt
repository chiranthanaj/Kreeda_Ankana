package com.example.kreedaankana.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kreedaankana.viewmodel.AppUiState

@Composable
fun TeamScreen(
    state: AppUiState,
    onSave: (String, String, String) -> Unit,
    onSignOut: () -> Unit
) {
    var teamName by remember { mutableStateOf(state.team.teamName) }
    var village by remember { mutableStateOf(state.team.village) }
    var sports by remember { mutableStateOf(state.team.sports.joinToString(", ")) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("My Team", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))

        Card {
            Column(Modifier.padding(16.dp)) {
                Text(state.team.teamName, style = MaterialTheme.typography.headlineSmall)
                Text(state.team.village)
                Spacer(Modifier.height(8.dp))
                Text("Matches: ${state.team.matches}  •  Wins: ${state.team.wins}  •  Slots: ${state.team.slotsUsed}")
                Text("Sports: ${state.team.sports.joinToString()}")
            }
        }

        Spacer(Modifier.height(12.dp))
        OutlinedTextField(teamName, { teamName = it }, label = { Text("Team name") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(village, { village = it }, label = { Text("Village") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(sports, { sports = it }, label = { Text("Sports (comma separated)") }, modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(12.dp))
        Button(onClick = { onSave(teamName, village, sports) }, modifier = Modifier.fillMaxWidth()) {
            Text("Save team")
        }

        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onSignOut, modifier = Modifier.fillMaxWidth()) {
            Text("Sign out")
        }
    }
}
