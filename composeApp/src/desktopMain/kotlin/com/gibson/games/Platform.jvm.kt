package com.gibson.games

import androidx.compose.runtime.Composable

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()
@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) {

}