package com.appzlogic.fatchusers.repository

import androidx.lifecycle.LiveData
import com.appzlogic.fatchusers.database.User
import com.appzlogic.fatchusers.database.UserDao

class UserDBRepo(private val userDao: UserDao) {
    val allFavUser: LiveData<List<User>> = userDao.getAllUser()

    suspend fun insertUser(user: MutableList<User>) {
        userDao.insertUser(user)
    }
}