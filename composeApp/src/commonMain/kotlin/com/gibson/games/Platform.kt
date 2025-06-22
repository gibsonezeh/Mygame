package com.gibson.games

import androidx.compose.runtime.Composable


//import androidx.activity.compose.BackHandler
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
@Composable
expect fun BackHandler(enabled: Boolean, onBack: () -> Unit)