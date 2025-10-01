package com.example.jetpackcomposedemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform