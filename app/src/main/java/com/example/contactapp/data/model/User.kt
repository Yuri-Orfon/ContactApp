package com.example.contactapp.data.model

import java.io.Serializable

data class User(
    val img: String,
    val name: String,
    val id: Int,
    val userName: String
) : Serializable