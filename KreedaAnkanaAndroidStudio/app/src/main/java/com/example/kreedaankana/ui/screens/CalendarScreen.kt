package com.example.kreedaankana.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kreedaankana.viewmodel.AppUiState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val slots = listOf(
    "6 AM - 8 AM",
    "9 AM - 10 AM",
    "10.30 AM - 12.30 PM",
    "4 PM - 6 PM",
    "6 PM - 8 PM"
)

@Composable
fun CalendarScreen(
    state: AppUiState,
    onGroundSelected: (String) -> Unit,
    onDateSelected: (LocalDate) -> Unit,
    onBook: (String, String, String) -> Unit
) {
    var openBooking by remember { mutableStateOf<String?>(null) }
    var sport by remember { mutableStateOf("Cricket") }
    var teamName by remember { mutableStateOf(state.team.teamName) }

    val today = remember { LocalDate.now() }
    val dateRange = remember(today) {
        (-365..365).map { today.plusDays(it.toLong()) }
    }

    val selectedKey = state.selectedDate.format(DateTimeFormatter.ISO_DATE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ground Calendar",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(end = 8.dp)
        ) {
            items(
                items = listOf(
                    "Kodipalya Ground",
                    "Hemmige Maidan",
                    "Bannur Field",
                    "T. Narasipur Park"
                )
            ) { ground ->
                FilterChip(
                    selected = state.currentGround == ground,
                    onClick = { onGroundSelected(ground) },
                    label = { Text(ground) }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Select date",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(
                items = dateRange,
                key = { it.toString() }
            ) { day ->
                val isSelected = day == state.selectedDate
                val hasBooking = state.bookings.any {
                    it.dateKey == day.format(DateTimeFormatter.ISO_DATE)
                }

                Column(
                    modifier = Modifier
                        .width(78.dp)
                        .background(
                            color = if (isSelected)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { onDateSelected(day) }
                        .padding(8.dp)
                ) {
                    Text(
                        text = day.dayOfWeek.name.take(3),
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text(
                        text = day.dayOfMonth.toString(),
                        style = MaterialTheme.typography.titleMedium
                    )
                    if (hasBooking) {
                        Text(
                            text = "•",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${state.currentGround} • ${state.selectedDate}",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        val bookingsForDay = state.bookings.filter {
            it.ground == state.currentGround && it.dateKey == selectedKey
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            items(slots) { slot ->
                val booking = bookingsForDay.firstOrNull { it.slot == slot }

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = slot,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        if (booking == null) {
                            Text(
                                text = "Free slot",
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { openBooking = slot }
                            ) {
                                Text("Book slot")
                            }
                        } else {
                            Text(
                                text = "Slot booked",
                                color = MaterialTheme.colorScheme.error,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Booked by ${booking.teamName} • ${booking.sport}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }

    if (openBooking != null) {
        AlertDialog(
            onDismissRequest = { openBooking = null },
            title = { Text("Book slot") },
            text = {
                Column {
                    Text("Date: $selectedKey")
                    Text("Slot: ${openBooking ?: ""}")
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = teamName,
                        onValueChange = { teamName = it },
                        label = { Text("Team name") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = sport,
                        onValueChange = { sport = it },
                        label = { Text("Sport") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onBook(
                            openBooking.orEmpty(),
                            sport,
                            teamName.ifBlank { state.team.teamName }
                        )
                        openBooking = null
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { openBooking = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}