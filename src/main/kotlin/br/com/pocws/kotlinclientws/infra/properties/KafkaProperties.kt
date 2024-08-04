package br.com.pocws.kotlinclientws.infra.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "kafka")
class KafkaProperties {

    var bootstrapServers: String = ""
    var poolTimeout: Int = 0
    var autoCreateTopic: Boolean = false

}