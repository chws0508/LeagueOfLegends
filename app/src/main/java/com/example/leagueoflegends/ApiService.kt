package com.example.leagueoflegends

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("champions/en-us") // baseUrl + "user/유저아이디"
    fun getChampionList(
        @Header("X-RapidAPI-Key")key :String,//헤더부분 어노테이션 붙여서 함
        @Header("X-RapidAPI-Host")host : String,
        @Query("page")page:Int,
        @Query("size")size:Int
    ): Call<ChampionListResponse>

//    @GET("champions/en-us/{name}")
//    fun getChampion(
//        @Header("X-RapidAPI-Key")key :String,//헤더부분 어노테이션 붙여서 함
//        @Header("X-RapidAPI-Host")host : String
//    ): Call<Node>
}