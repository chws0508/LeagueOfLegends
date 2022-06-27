package com.example.leagueoflegends

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("champions/all") // baseUrl + "user/유저아이디"
    fun getUserInfo(
        @Header("X-RapidAPI-Key")key :String,//헤더부분 어노테이션 붙여서 함
        @Header("X-RapidAPI-Host")host : String,
    ): Call<List<ChampionInfo>>
}