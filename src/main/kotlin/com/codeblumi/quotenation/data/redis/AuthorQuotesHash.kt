package com.codeblumi.quotenation.data.redis

import com.codeblumi.quotenation.model.Quote
import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("author_quotes")
class AuthorQuotesHash(
    @Id
    val id: String,
    val internalId: String,
    val quotes: List<String>
) {
    companion object {
        fun fromQuote(quote: Quote): AuthorQuotesHash {
            return AuthorQuotesHash(
                id = quote.author,
                internalId = quote.id,
                quotes = listOf(quote.text)
            )
        }
    }

    fun withAnotherQuote(quote: String): AuthorQuotesHash {
        val newQuotes = quotes.toMutableList()
        newQuotes.add(quote)
        return AuthorQuotesHash(id, internalId, newQuotes)
    }
}