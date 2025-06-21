package com.gibson.games

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import games.composeapp.generated.resources.Res
import games.composeapp.generated.resources.compose_multiplatform

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.gibson.games.*

@Composable
@Preview
fun App() {
    var selectedGame by remember { mutableStateOf<Game?>(null) }

    Surface(modifier = Modifier.fillMaxSize()) {
        if (selectedGame == null) {
            GameMenu(onGameSelected = { selectedGame = it })
        } else {
            // When a game is selected, show the GameScreen.
            // The onExit lambda sets the selected game back to null, returning to the menu.
            GameScreen(game = selectedGame!!) {
                selectedGame = null
            }
        }
    }
}
