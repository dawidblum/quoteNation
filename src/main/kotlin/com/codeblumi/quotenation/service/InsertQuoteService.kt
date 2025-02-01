package com.codeblumi.quotenation.service

interface InsertQuoteService {
    fun insertQuote(text: String, author: String): String
}