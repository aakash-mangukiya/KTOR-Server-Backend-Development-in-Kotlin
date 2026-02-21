package com.example.di

import com.example.data.services.BlogServiceImpl
import com.example.domain.services.UserService
import com.example.data.services.UserServiceImpl
import com.example.domain.services.BlogService
import org.koin.dsl.module

val servicesModule = module {
    single<UserService>() {
        UserServiceImpl(get())
    }

    single<BlogService>() {
        BlogServiceImpl(get())
    }
}