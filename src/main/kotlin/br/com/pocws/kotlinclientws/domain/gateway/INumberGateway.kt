package br.com.pocws.kotlinclientws.domain.gateway

import java.util.UUID

interface INumberGateway {

    fun save(number: Number)

    fun getById(uuid: UUID): List<Number>

    fun delete(uuid: UUID)
}