package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.model.Quote
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaInsertQuoteService(
    private val kafkaTemplate: KafkaTemplate<String, Quote>,
    private val identifierProvider: IdentifierProvider
) : InsertQuoteService {
    override fun insertQuote(text: String, author: String) {
        Quote(identifierProvider.provide(), text, author).run {
            kafkaTemplate.send("quotes", this)
        }
    }
}