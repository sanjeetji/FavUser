package com.appzlogic.fatchusers.view

import UserAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.appzlogic.fatchusers.R
import com.appzlogic.fatchusers.database.User
import com.appzlogic.fatchusers.databinding.ActivityMainBinding
import com.appzlogic.fatchusers.repository.UserRepository
import com.appzlogic.fatchusers.service.RetrofitService
import com.appzlogic.fatchusers.viewModel.UserDBViewModel
import com.appzlogic.fatchusers.viewModel.UserViewModel
import com.appzlogic.fatchusers.viewModel.UserViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: UserViewModel
    lateinit var userViewModel: UserDBViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val userAdapter = UserAdapter()
    var users:MutableList<User>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.progressBar.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this, UserViewModelFactory(UserRepository(retrofitService))).get(UserViewModel::class.java)
        userViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(UserDBViewModel::class.java)


        users = arrayListOf()
        viewModel.getUsers()

        binding.userRv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        binding.btnFavUser.setOnClickListener {
            startActivity(Intent(this,FavUserActivity::class.java))
        }

        viewModel.data.observe(this, Observer {
            userAdapter.setItemList(it)
            binding.progressBar.visibility = View.GONE
        })

        userAdapter.itemClickListener {
            users?.add(User(0,it.name,it.email,it.username,it.address.city,it.website,it.company.name))
            userViewModel.insertStudent(users as ArrayList<User>)
        }
    }
}