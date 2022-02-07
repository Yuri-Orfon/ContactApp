package com.example.contactapp.data.datasource

import com.example.contactapp.data.model.User
import com.example.contactapp.data.service.UserService
import retrofit2.Call
import javax.inject.Inject

interface UserDataSource {
    fun getUsers(): Call<List<User>>
}

class RetrofitDataSource @Inject constructor(
    private val service: UserService
) : UserDataSource {
    override fun getUsers(): Call<List<User>> = service.getUsers()
}