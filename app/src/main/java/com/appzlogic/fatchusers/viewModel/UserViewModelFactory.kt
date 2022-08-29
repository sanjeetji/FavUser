package com.appzlogic.fatchusers.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appzlogic.fatchusers.repository.UserRepository

class UserViewModelFactory constructor(private val repository: UserRepository) :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserViewModel::class.java)){
            UserViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("View Model not found")
        }
    }
}