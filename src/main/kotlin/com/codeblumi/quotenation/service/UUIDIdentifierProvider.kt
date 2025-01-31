package com.codeblumi.quotenation.service

import org.springframework.stereotype.Component
import java.util.*

@Component
class UUIDIdentifierProvider : IdentifierProvider {
    override fun provide() = UUID.randomUUID().toString()
}