package com.codeblumi.quotenation.presentation

import com.codeblumi.quotenation.service.GetQuoteService
import com.codeblumi.quotenation.service.InsertQuoteService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quotes")
class QuoteController(
    private val insertQuoteService: InsertQuoteService,
    private val getQuoteService: GetQuoteService
) {
    @PostMapping("")
    fun insertQuote(@RequestBody request: InsertQuoteRequest) {
        insertQuoteService.insertQuote(request.text, request.author)
    }
}

data class InsertQuoteRequest(
    val text: String,
    val author: String
)