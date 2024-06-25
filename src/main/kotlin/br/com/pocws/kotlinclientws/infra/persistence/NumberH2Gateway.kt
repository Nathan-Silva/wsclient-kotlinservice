package br.com.pocws.kotlinclientws.infra.persistence

import br.com.pocws.kotlinclientws.domain.gateway.INumberGateway
import br.com.pocws.kotlinclientws.infra.persistence.repository.INumberRepository
import java.util.*

class NumberH2Gateway(private val iNumberRepository: INumberRepository) : INumberGateway {

    override fun save(number: Number) {
        TODO("Not yet implemented")
    }

    override fun getById(uuid: UUID): List<Number> {
        TODO("Not yet implemented")
    }

    override fun delete(uuid: UUID) {
        TODO("Not yet implemented")
    }
}