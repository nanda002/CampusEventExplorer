package com.example.campuseventexplorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventSelected: (Long) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Campus Event Explorer") }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                label = { Text("Search events") },
                placeholder = { Text("Search by title or category") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Text(
                text = "${events.size} events found",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            if (events.isEmpty()) {
                Text(
                    text = "No events found. Try another search.",
                    modifier = Modifier.padding(top = 16.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        items = events,
                        key = { event -> event.id }
                    ) { event ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onEventSelected(event.id)
                                }
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement =
                                    Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = event.title,
                                    style =
                                        MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = event.category,
                                    style =
                                        MaterialTheme.typography.labelMedium,
                                    color =
                                        MaterialTheme.colorScheme.primary
                                )

                                Row {
                                    Text(
                                        text = "Location: ",
                                        style =
                                            MaterialTheme.typography.bodyMedium
                                    )
                                    Text(
                                        text = event.location,
                                        style =
                                            MaterialTheme.typography.bodyMedium
                                    )
                                }

                                Text(
                                    text = event.time,
                                    style =
                                        MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}