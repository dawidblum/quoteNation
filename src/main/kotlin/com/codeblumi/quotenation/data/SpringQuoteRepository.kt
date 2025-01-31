package com.codeblumi.quotenation.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringQuoteRepository : JpaRepository<QuoteEntity, String> {
    fun getQuoteById(id: String): QuoteEntity?
    fun getQuotesByAuthor(author: String): List<QuoteEntity>
}