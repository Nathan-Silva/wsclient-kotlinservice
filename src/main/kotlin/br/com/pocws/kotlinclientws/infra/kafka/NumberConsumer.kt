package br.com.pocws.kotlinclientws.infra.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class NumberConsumer {

    private val LOG: Logger = LoggerFactory.getLogger(NumberConsumer::class.java)

    @KafkaListener(
        id = "\${kafka.consumers.number-consumer.id}",
        topics = ["\${kafka.consumers.number-consumer.topics}"],
        concurrency = "\${kafka.consumers.number-consumer.concurrency}",
        containerFactory = "kafkaListenerFactory",
        groupId = "\${kafka.consumers.number-consumer.group-id}",
        properties = ["auto.offset.reset=\${kafka.consumers.number-consumer.auto-offset-reset}"]
    )
    fun onMessage(@Payload(required = false) payload: String, consumerRecordMetadata: ConsumerRecordMetadata) {
        LOG.info(
            "Message received from Kafka [topic:{}] [partition:{}] [offset:{}]: {}",
            consumerRecordMetadata.topic(),
            consumerRecordMetadata.partition(),
            consumerRecordMetadata.offset(),
            payload
        )

    }
}