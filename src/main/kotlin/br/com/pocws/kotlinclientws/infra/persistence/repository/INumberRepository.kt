package br.com.pocws.kotlinclientws.infra.persistence.repository

import br.com.pocws.kotlinclientws.infra.persistence.model.NumberModel
import org.springframework.data.jpa.repository.JpaRepository

interface INumberRepository : JpaRepository<NumberModel, String> {
}