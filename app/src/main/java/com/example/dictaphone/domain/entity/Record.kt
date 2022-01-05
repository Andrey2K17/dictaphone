package com.example.dictaphone.domain.entity

import java.util.*

data class Record(
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var duration: String,
)
