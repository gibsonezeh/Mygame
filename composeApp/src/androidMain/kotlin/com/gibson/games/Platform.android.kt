package com.gibson.games

import android.os.Build
import androidx.compose.runtime.Composable

actual fun getPlatform(): Platform = AndroidPlatform()
class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}


@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) {
    androidx.activity.compose.BackHandler(enabled = enabled, onBack = onBack)
}