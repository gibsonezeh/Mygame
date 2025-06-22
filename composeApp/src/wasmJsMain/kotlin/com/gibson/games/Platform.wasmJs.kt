package com.gibson.games

import androidx.compose.runtime.Composable

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()
@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit){

}