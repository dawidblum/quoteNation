package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.data.jpa.SpringQuoteRepository
import com.codeblumi.quotenation.data.redis.QuoteHash
import com.codeblumi.quotenation.data.redis.RedisQuoteRepository
import com.codeblumi.quotenation.model.Quote
import org.springframework.stereotype.Service

@Service
class DefaultGetQuoteService(
    private val quoteRepository: SpringQuoteRepository,
    private val redisQuoteRepository: RedisQuoteRepository
) : GetQuoteService {
    override fun getQuote(id: String): Quote =
        redisQuoteRepository.findById(id)
            .map { it.toQuote() }
            .orElseGet { quoteRepository.getQuoteById(id)?.toQuote() }
            .also {
                it?.let { redisQuoteRepository.save(QuoteHash.fromQuote(it)) }
            }

    override fun getAuthorQuotes(author: String) = quoteRepository.getQuotesByAuthor(author).map { it.toQuote() }
}