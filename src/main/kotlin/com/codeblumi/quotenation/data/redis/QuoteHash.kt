package com.codeblumi.quotenation.data.redis

import com.codeblumi.quotenation.model.Quote
import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("quote")
data class QuoteHash(
    @Id
    val id: String,
    val text: String,
    val author: String
) {
    companion object {
        fun fromQuote(quote: Quote): QuoteHash {
            return QuoteHash(
                id = quote.id,
                text = quote.text,
                author = quote.author
            )
        }
    }

    fun toQuote(): Quote {
        return Quote(
            id = id,
            text = text,
            author = author
        )
    }
}