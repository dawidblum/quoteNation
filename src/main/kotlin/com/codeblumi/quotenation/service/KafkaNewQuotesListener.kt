package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.model.Quote
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaNewQuotesListener {
    @KafkaListener(topics = ["quotes"])
    fun listen(newQuote: Quote) {
        println("Received new quote: $newQuote")
    }
}