package com.codeblumi.quotenation.presentation

import com.codeblumi.quotenation.service.GetQuoteService
import com.codeblumi.quotenation.service.InsertQuoteService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quotes")
class QuoteController(
    private val insertQuoteService: InsertQuoteService,
    private val getQuoteService: GetQuoteService
) {
    @PostMapping
    fun insertQuote(@RequestBody request: InsertQuoteRequest): ResponseEntity<Void> =
        insertQuoteService.insertQuote(request.text, request.author)
            .let {
                ResponseEntity.status(HttpStatus.CREATED)
                    .header(HttpHeaders.LOCATION, "/quotes/$it")
                    .build()
            }

    @GetMapping("/{id}")
    fun getQuote(@PathVariable id: String) = getQuoteService.getQuote(id)

    @GetMapping
    fun getAuthorQuotes(@RequestParam(required = true) author: String) = getQuoteService.getAuthorQuotes(author)
}

data class InsertQuoteRequest(
    val text: String,
    val author: String
)