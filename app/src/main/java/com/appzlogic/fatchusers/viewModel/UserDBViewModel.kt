package com.appzlogic.fatchusers.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.appzlogic.fatchusers.database.User
import com.appzlogic.fatchusers.database.UserDatabase
import com.appzlogic.fatchusers.repository.UserDBRepo
import com.appzlogic.fatchusers.repository.UserRepository
import com.appzlogic.fetchuser.model.UsersItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDBViewModel constructor(application: Application):AndroidViewModel(application) {
    var allUser : LiveData<List<User>>
    private val repository: UserDBRepo

    init {
        val dao = UserDatabase.getDatabase(application).userDao()
        repository = UserDBRepo(dao)
        allUser = repository.allFavUser
    }

    fun insertStudent(user:MutableList<User>) = viewModelScope.launch(Dispatchers.IO){
        repository.insertUser(user)
    }

}