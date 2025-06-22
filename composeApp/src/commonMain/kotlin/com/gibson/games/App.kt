package com.gibson.games

import androidx.compose.ui.Modifier

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.remember

@Composable
fun App() {
    var selectedGame by remember {
        mutableStateOf<Game?>(null)
    }
    Surface(modifier =Modifier.fillMaxSize()) {
        if (selectedGame == null) {
            GameMenu(onGameSelected = { selectedGame = it})
        }else{
            GameScreen(
                game = selectedGame!!,
                onExit = {selectedGame = null}
            )
        }
    }

}
