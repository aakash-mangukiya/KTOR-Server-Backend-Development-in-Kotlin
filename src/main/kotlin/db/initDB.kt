package com.example.db

import com.example.db.tables.BlogsTable
import com.example.db.tables.UsersTable
import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.initDB() {

    val url = environment.config.property("database.url").getString()
    val user = environment.config.property("database.user").getString()
    val driver = environment.config.property("database.driver").getString()
    val password = environment.config.property("database.password").getString()

    val db = Database.connect(
        url = url,
        driver = driver,
        user = user,
        password = password
    )

    transaction(db) {
        SchemaUtils.create(UsersTable, BlogsTable)
    }
}