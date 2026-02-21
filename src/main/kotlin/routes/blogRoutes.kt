package com.example.routes

import com.example.domain.models.CreateBlogRequest
import com.example.domain.models.UpdateBlogRequest
import com.example.domain.models.User
import com.example.domain.services.BlogService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.blogRoutes(blogService: BlogService) {
    routing {
        authenticate("auth-jwt") {
            route("/api/blogs") {
                get {
                    val blogs = blogService.getAllBlogs()
                    if (blogs != null) {
                        call.respond(HttpStatusCode.OK, blogs)
                    } else {
                        call.respond(HttpStatusCode.BadGateway, "Please try after some time")
                    }
                }

                post {

                    val request = call.receive<CreateBlogRequest>()
                    val user = call.authentication.principal<User>()

                    if (user != null) {
                        val blog = blogService.createBlog(request, user.id)
                        if (blog != null) {
                            call.respond(HttpStatusCode.Created, blog)
                        } else {
                            call.respond(HttpStatusCode.Conflict, "Failed to create blog")
                        }
                    } else {
                        call.respond(HttpStatusCode.Unauthorized, "User not authenticated")
                    }
                }

                put("/{id}") {

                    val id = call.parameters["id"]?.toIntOrNull()
                    if (id == null) {
                        call.respond(HttpStatusCode.BadRequest, "invalid id")
                        return@put
                    }

                    val request = call.receive<UpdateBlogRequest>()
                    val user = call.authentication.principal<User>()

                    if (user != null) {
                        val blog = blogService.updateBlog(id, request, user.id)
                        if (blog != null) {
                            call.respond(HttpStatusCode.OK, blog)
                        } else {
                            call.respond(HttpStatusCode.NotFound, "Failed to update blog, blog not found")
                        }
                    } else {
                        call.respond(HttpStatusCode.Unauthorized, "User not authenticated")
                    }
                }

                delete("/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull()
                    if (id == null) {
                        call.respond(HttpStatusCode.BadRequest, "invalid id")
                        return@delete
                    }

                    val user = call.authentication.principal<User>()

                    if (user != null) {
                        val deleted = blogService.deleteBlog(id, user.id)
                        if (deleted) {
                            call.respond(HttpStatusCode.OK, "blog deleted successfully!")
                        } else {
                            call.respond(HttpStatusCode.NotFound, "Failed to delete blog, blog not found")
                        }
                    } else {
                        call.respond(HttpStatusCode.Unauthorized, "User not authenticated")
                    }
                }
            }
        }
    }
}