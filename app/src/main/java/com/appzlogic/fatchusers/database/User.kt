package com.appzlogic.fatchusers.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var email: String,
    var userName:String,
    var city: String,
    var website:String,
    var company: String,
)
