package com.appzlogic.fatchusers.service

import com.appzlogic.fetchuser.model.UsersItem
import com.appzlogic.fetchuser.util.Constant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    fun getUsers(): Call<List<UsersItem>>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}