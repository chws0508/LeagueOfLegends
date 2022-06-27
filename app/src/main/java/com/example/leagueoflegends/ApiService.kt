package com.example.leagueoflegends

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("getPercentage") // baseUrl + "user/유저아이디"
    fun getUserInfo(
        @Header("X-RapidAPI-Key")key :String,//헤더부분 어노테이션 붙여서 함
        @Header("X-RapidAPI-Host")host : String,
        @Query("sname")wName : String,
        @Query("fname")mName: String//매개변수(파라미터) 부분 적기
    ): Call<UserInfo>
}