package com.codeblumi.quotenation.data.redis

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RedisQuoteRepository : CrudRepository<QuoteHash, String>