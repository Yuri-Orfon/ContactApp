package com.example.contactapp.data.repository

import com.example.contactapp.data.model.User
import retrofit2.Call

interface UserRepositoryInterface {
    fun getUsers(): Call<List<User>>
}