package br.com.pocws.kotlinclientws.domain.entity

import java.time.Instant
import java.util.*

data class Number(
    val id: UUID,
    val number: Int,
    val numberText: String,
    val createAt: Instant
)
