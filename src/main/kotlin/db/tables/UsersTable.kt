package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

const val MAX_VARCHAR_LENGTH = 100

object UsersTable : IntIdTable() {
    val username = varchar("username", MAX_VARCHAR_LENGTH).uniqueIndex()
    val password = varchar("director", MAX_VARCHAR_LENGTH)
}