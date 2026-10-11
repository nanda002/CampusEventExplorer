package com.example.campuseventexplorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: CampusEvent?,
    onBack: () -> Unit,
    onShare: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Event Details") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("‹ Back")
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            if (event == null) {
                Text(
                    text = "Event unavailable",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "This event could not be found."
                )

                Button(onClick = onBack) {
                    Text("Return to events")
                }
            } else {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = event.category,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Divider()

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Date/time: ",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = event.time,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Location: ",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = event.location,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Text(
                    text = "About this event",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = event.description,
                    style = MaterialTheme.typography.bodyLarge
                )

                Button(
                    onClick = onShare,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Share event")
                }
            }
        }
    }
}