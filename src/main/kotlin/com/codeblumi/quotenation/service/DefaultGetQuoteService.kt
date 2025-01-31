package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.data.SpringQuoteRepository
import org.springframework.stereotype.Service

@Service
class DefaultGetQuoteService(
    private val quoteRepository: SpringQuoteRepository
) : GetQuoteService {
    override fun getQuote(id: String) = quoteRepository.getQuoteById(id)?.toQuote()

    override fun getAuthorQuotes(author: String) = quoteRepository.getQuotesByAuthor(author).map { it.toQuote() }
}