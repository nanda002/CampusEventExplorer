package com.example.campuseventexplorer


import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun EventNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // The search state survives rotation and remains when
    // the user opens an event and returns to the list.
    var query by rememberSaveable {
        mutableStateOf("")
    }

    val events = campusEvents

    // Derive the visible list from the query.
    // Do not maintain a separate mutable filtered list.
    val filteredEvents = remember(query, events) {
        events.filter { event ->
            event.title.contains(query, ignoreCase = true) ||
                    event.category.contains(query, ignoreCase = true)
        }
    }

    NavHost(
        navController = navController,
        startDestination = EventList
    ) {
        composable<EventList> {
            EventListScreen(
                events = filteredEvents,
                query = query,
                onQueryChange = { newQuery ->
                    query = newQuery
                },
                onEventSelected = { eventId ->
                    navController.navigate(
                        EventDetail(eventId = eventId)
                    )
                }
            )
        }

        composable<EventDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<EventDetail>()

            val event = events.firstOrNull {
                it.id == route.eventId
            }

            EventDetailScreen(
                event = event,
                onBack = {
                    if (!navController.popBackStack()) {
                        navController.navigate(EventList) {
                            popUpTo<EventList> {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }
                },
                onShare = {
                    if (event != null) {
                        val shareText =
                            "${event.title} — ${event.time} — ${event.location}"

                        val sendIntent = Intent(
                            Intent.ACTION_SEND
                        ).apply {
                            type = "text/plain"
                            putExtra(
                                Intent.EXTRA_TEXT,
                                shareText
                            )
                        }

                        val chooser = Intent.createChooser(
                            sendIntent,
                            "Share campus event"
                        )

                        context.startActivity(chooser)
                    }
                }
            )
        }
    }
}