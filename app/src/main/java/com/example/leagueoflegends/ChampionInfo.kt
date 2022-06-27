package com.example.leagueoflegends

import com.google.gson.annotations.SerializedName

data class ChampionInfo(
   val name : String,
val role:String,
val tier:String,
val score: String,
val trend: String,
val winRate:String,
val rolePick:String,
val pickRate:String,
val banRate: String,
val kda : String
)
