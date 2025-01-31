package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.data.QuoteEntity
import com.codeblumi.quotenation.model.Quote
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import com.codeblumi.quotenation.data.SpringQuoteRepository

@Component
class KafkaNewQuotesListener(
    private val quoteService: SpringQuoteRepository
) {
    @KafkaListener(topics = ["quotes"])
    fun listen(newQuote: Quote) {
        quoteService.save(QuoteEntity.fromQuote(newQuote))
    }
}