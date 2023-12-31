package com.example.notesjpcompose.model

import java.time.LocalDateTime
import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryPoint: LocalDateTime = LocalDateTime.now()
)
