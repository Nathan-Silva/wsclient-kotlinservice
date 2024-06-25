package br.com.pocws.kotlinclientws.app.usecase

import br.com.pocws.kotlinclientws.domain.gateway.INumberGateway
import java.util.*

class NumberUseCase(private val iNumberGateway: INumberGateway) {

    fun save(number: Number) {
        iNumberGateway.save(number)
    }

    fun delete(uuid: UUID) {
        iNumberGateway.delete(uuid)
    }

    fun getById(uuid: UUID): List<Number> {
        return iNumberGateway.getById(uuid)
    }
}