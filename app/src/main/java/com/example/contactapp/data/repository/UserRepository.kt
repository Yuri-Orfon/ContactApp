package com.example.contactapp.data.repository

import com.example.contactapp.data.datasource.UserDataSource
import com.example.contactapp.data.model.User
import retrofit2.Call
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDataSource: UserDataSource
    ) : UserRepositoryInterface {

    override fun getUsers(): Call<List<User>> = userDataSource.getUsers()
}