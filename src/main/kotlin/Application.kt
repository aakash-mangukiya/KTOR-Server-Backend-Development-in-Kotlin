package com.example

import com.example.db.initDB
import com.example.di.configureKoin
import com.example.domain.services.BlogService
import com.example.domain.services.UserService
import com.example.security.configSecurity
import io.ktor.server.application.*
import org.koin.ktor.ext.get
import com.example.routes.blogRoutes
import com.example.routes.userRoutes
import security.configureContentNegotiation

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureContentNegotiation()
    initDB()
    val userService = get<UserService>()
    configSecurity(userService)
    val blogService = get<BlogService>()
    userRoutes(userService)
    blogRoutes(blogService)
}
