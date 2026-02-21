package com.example.db.entities

import com.example.db.tables.BlogsTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class BlogEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BlogEntity>(BlogsTable)

    var title by BlogsTable.title
    var content by BlogsTable.content
    var author by UserEntity referencedOn BlogsTable.author

}