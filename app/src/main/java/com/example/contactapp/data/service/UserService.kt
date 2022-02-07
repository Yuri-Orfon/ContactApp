package com.example.contactapp.data.service

import com.example.contactapp.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun getUsers(): Call<List<User>>
}