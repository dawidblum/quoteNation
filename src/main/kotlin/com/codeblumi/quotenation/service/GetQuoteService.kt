package com.codeblumi.quotenation.service

import com.codeblumi.quotenation.model.Quote

interface GetQuoteService {
    fun getQuote(id: String): Quote?
    fun getAuthorQuotes(author: String): List<Quote>
}