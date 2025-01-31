package com.codeblumi.quotenation.data.redis

import org.springframework.data.repository.CrudRepository

interface RedisAuthorQuotesRepository : CrudRepository<AuthorQuotesHash, String>