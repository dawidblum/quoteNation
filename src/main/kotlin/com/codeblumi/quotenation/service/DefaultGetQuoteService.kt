package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.model.Quote
import org.springframework.stereotype.Service

@Service
class DefaultGetQuoteService : GetQuoteService {
    override fun getQuote(id: String): Quote? {
        TODO("Not yet implemented")
    }

    override fun getAuthorQuotes(author: String): List<Quote> {
        TODO("Not yet implemented")
    }
}