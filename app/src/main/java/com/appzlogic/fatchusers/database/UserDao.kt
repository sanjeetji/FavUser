package com.appzlogic.fatchusers.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user:MutableList<User>)

    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<User>>

}