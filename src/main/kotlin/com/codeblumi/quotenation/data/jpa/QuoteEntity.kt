package com.codeblumi.quotenation.data.jpa

import com.codeblumi.quotenation.model.Quote
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "quotes")
class QuoteEntity(
    @Id
    val id: String,
    @Column
    val text: String,
    @Column
    val author: String
) {
    companion object {
        fun fromQuote(quote: Quote): QuoteEntity {
            return QuoteEntity(
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