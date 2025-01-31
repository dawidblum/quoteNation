package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.data.jpa.SpringQuoteRepository
import com.codeblumi.quotenation.data.redis.RedisAuthorQuotesRepository
import com.codeblumi.quotenation.data.redis.RedisQuoteRepository
import com.codeblumi.quotenation.model.Quote
import org.springframework.stereotype.Service

@Service
class DefaultGetQuoteService(
    private val quoteRepository: SpringQuoteRepository,
    private val redisQuoteRepository: RedisQuoteRepository,
    private val redisAuthorQuotesRepository: RedisAuthorQuotesRepository
) : GetQuoteService {
    override fun getQuote(id: String): Quote =
        redisQuoteRepository.findById(id)
            .map { it.toQuote() }
            .orElseGet { quoteRepository.getQuoteById(id)?.toQuote() }

    override fun getAuthorQuotes(author: String): List<Quote> = redisAuthorQuotesRepository.findById(author)
        .map { it.quotes.map { text -> Quote(it.internalId, text, it.id) } }
        .orElseGet { quoteRepository.getQuotesByAuthor(author).map { it.toQuote() } }
}