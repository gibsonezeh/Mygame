package com.gibson.games

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform