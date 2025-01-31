package com.codeblumi.quotenation.data

import com.codeblumi.quotenation.model.Quote
import org.springframework.data.repository.CrudRepository

interface SpringQuoteRepository : CrudRepository<Quote, String> {
    fun insertQuote(quote: Quote)
    fun getQuoteById(id: String): Quote?
    fun getQuotesByAuthor(author: String): List<Quote>
}