package com.batch15.usermanagementservice.producer

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer<T>(
    private val kafkaTemplate: KafkaTemplate<String, T>
) {
    val log = LoggerFactory.getLogger(this::class.java)

    fun sendMessage(topic: String, message: T) {
        log.info("Sending Message $message of topic : $topic")
        kafkaTemplate.send(topic, message)
    }
}