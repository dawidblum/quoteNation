package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.data.jpa.QuoteEntity
import com.codeblumi.quotenation.model.Quote
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import com.codeblumi.quotenation.data.jpa.SpringQuoteRepository
import com.codeblumi.quotenation.data.redis.AuthorQuotesHash
import com.codeblumi.quotenation.data.redis.QuoteHash
import com.codeblumi.quotenation.data.redis.RedisAuthorQuotesRepository
import com.codeblumi.quotenation.data.redis.RedisQuoteRepository

@Component
class KafkaNewQuotesListener(
    private val quoteService: SpringQuoteRepository,
    private val redisQuoteRepository: RedisQuoteRepository,
    private val redisAuthorQuotesRepository: RedisAuthorQuotesRepository
) {
    @KafkaListener(topics = ["quotes"])
    fun listen(newQuote: Quote) {
        quoteService.save(QuoteEntity.fromQuote(newQuote))
            .also { redisQuoteRepository.save(QuoteHash.fromQuote(newQuote)) }
            .also { saveAuthorQuotes(newQuote) }
    }

    private fun saveAuthorQuotes(quote: Quote) {
        quote.author.let { author ->
            redisAuthorQuotesRepository.findById(author)
                .map { authorQuotes -> authorQuotes.withAnotherQuote(quote.text) }
                .orElseGet { AuthorQuotesHash.fromQuote(quote) }
                .let { redisAuthorQuotesRepository.save(it) }
        }
    }
}