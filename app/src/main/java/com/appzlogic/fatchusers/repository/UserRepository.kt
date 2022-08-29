package com.appzlogic.fatchusers.repository

import com.appzlogic.fatchusers.service.RetrofitService

class UserRepository constructor(private val retrofitService: RetrofitService) {
    fun getUsers() = retrofitService.getUsers()
}