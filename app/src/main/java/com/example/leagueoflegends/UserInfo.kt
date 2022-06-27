package com.example.leagueoflegends

import com.google.gson.annotations.SerializedName

data class UserInfo(
    val fname : String,
    val sname : String,
    val percentage : Int,
    val result : String
)
