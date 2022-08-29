package com.appzlogic.fatchusers.view

import FavUserAdapter
import UserAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.appzlogic.fatchusers.R
import com.appzlogic.fatchusers.database.User
import com.appzlogic.fatchusers.databinding.ActivityFavUserBinding
import com.appzlogic.fatchusers.databinding.ActivityMainBinding
import com.appzlogic.fatchusers.viewModel.UserDBViewModel

class FavUserActivity : AppCompatActivity() {

    private val favUserAdapter = FavUserAdapter()
    private lateinit var binding: ActivityFavUserBinding
    lateinit var userViewModel: UserDBViewModel
    var user:List<User>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        userViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(UserDBViewModel::class.java)
        user = arrayListOf()

        binding.userRv.apply {
            adapter = favUserAdapter
            layoutManager = LinearLayoutManager(this@FavUserActivity)
        }
        binding.backBtn.setOnClickListener {
            finish()
        }
        userViewModel.allUser.observe(this, Observer {
            favUserAdapter.setItemList(it)
        })
    }
}