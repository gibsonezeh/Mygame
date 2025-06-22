package com.gibson.games

import androidx.compose.runtime.*

/**
 * A wrapper screen for the selected game. It handles the top-level back navigation.
 */
@Composable
fun GameScreen(game: Game, onExit: () -> Unit) {
    when (game) {
        Game.LUDO -> {LudoNavigationScreen(onExit = onExit)}

                    Game.CHECKERS -> { /* TODO: Implement Checkers Screen */
                    }

                    Game.SNAKE -> { /* TODO: Implement Snake Screen */
                    }

                    Game.CHESS -> { /* TODO: Implement Chess Screen */
                    }

                    Game.TIC_TAC_TOE -> { /* TODO: Implement TicTacToe Screen */
                    }
                    // Add other games here
                }
            }

/**
 * Navigation controller for Ludo game screens
 */
@Composable
fun LudoNavigationScreen(onExit: () -> Unit) {
    var currentScreen by remember { mutableStateOf("main_menu") }

    // BackHandler for returning from Ludo main menu to game selection
    if (currentScreen == "main_menu") {

    }
}
