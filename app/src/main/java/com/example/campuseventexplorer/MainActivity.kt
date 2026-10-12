
package com.example.campuseventexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val CampusRed = Color(0xFFB71C2C)
private val CampusRedDark = Color(0xFF8F1421)
private val CampusBackground = Color(0xFFF4F4F5)
private val CampusWhite = Color(0xFFFFFFFF)
private val CampusBlack = Color(0xFF191919)
private val CampusGrey = Color(0xFF66666F)

private val CampusColorScheme = lightColorScheme(
    primary = CampusRed,
    onPrimary = CampusWhite,
    primaryContainer = Color(0xFFF9DDE0),
    onPrimaryContainer = CampusRedDark,
    background = CampusBackground,
    onBackground = CampusBlack,
    surface = CampusWhite,
    onSurface = CampusBlack,
    surfaceVariant = Color(0xFFE8E8EB),
    onSurfaceVariant = CampusGrey,
    outline = Color(0xFFD4D4D8)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme(
                colorScheme = CampusColorScheme
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EventNavigation()
                }
            }
        }
    }
}
