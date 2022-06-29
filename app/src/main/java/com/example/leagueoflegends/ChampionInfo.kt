package com.example.leagueoflegends

data class ChampionInfo(
    val publish_details: Publish_Details,
    val uid:String,
    val url:String,
    val champion_name:String,
    val champion_splash:String,
    val recommended_roles:List<String>,
    val difficulty:Int,
    val champion:Champion
)

