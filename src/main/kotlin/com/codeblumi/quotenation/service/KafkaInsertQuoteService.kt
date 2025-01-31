package com.codeblumi.quotenation.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import com.codeblumi.quotenation.model.Quote
import java.util.*

@Service
class KafkaInsertQuoteService(
    private val kafkaTemplate: KafkaTemplate<String, Quote>
) : InsertQuoteService {
    override fun insertQuote(text: String, author: String) {
        Quote(UUID.randomUUID().toString(), text, author).run {
            kafkaTemplate.send("quotes", this)
        }
    }
}