package com.appzlogic.fatchusers.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appzlogic.fatchusers.repository.UserRepository
import com.appzlogic.fetchuser.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel constructor(private val repository: UserRepository):ViewModel() {
    val data = MutableLiveData<List<UsersItem>>()
    val errorMsg = MutableLiveData<String>()

    fun getUsers(){
        val response = repository.getUsers()
        response.enqueue(object :Callback<List<UsersItem>>{
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }

        })
    }
}