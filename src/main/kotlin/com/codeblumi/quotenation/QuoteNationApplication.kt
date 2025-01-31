package com.codeblumi.quotenation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.codeblumi.quotenation"])
@EntityScan(basePackages = ["com.codeblumi.quotenation.data"])
@EnableJpaRepositories(basePackages = ["com.codeblumi.quotenation.data"])
class QuoteNationApplication

fun main(args: Array<String>) {
    runApplication<QuoteNationApplication>(*args)
}
