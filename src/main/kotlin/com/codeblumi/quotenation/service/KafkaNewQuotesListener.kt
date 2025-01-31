package com.codeblumi.quotenation.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaNewQuotesListener {
    @KafkaListener(topics = ["quotes"])
    fun listen(message: String) {
        println("Received Messasge in group foo: $message")
    }
}