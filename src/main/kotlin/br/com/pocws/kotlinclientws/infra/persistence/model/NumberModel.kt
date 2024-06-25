package br.com.pocws.kotlinclientws.infra.persistence.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.Instant

@Entity
data class NumberModel(
    @Id
    val id: String,
    val number: Int,
    val numberText: String,
    val createAt: Instant
)
