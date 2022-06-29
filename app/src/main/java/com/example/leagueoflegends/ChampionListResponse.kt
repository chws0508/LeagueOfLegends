package com.example.leagueoflegends

data class ChampionListResponse(
    val champions:List<Node>,
    val page:PageInfo
)

data class PageInfo(
    val start:Int,
    val end:Int,
    val totalCount:Int
)

data class Publish_Details(
    val locale: String
)

data class Champion(
    val profile_image: Profile_Image
)
data class Profile_Image(
    val url:String
)



