package com.codebaron.comicapp.models

data class ComicDTO(
    val alt: String,
    val day: String,
    val img: String,
    val link: String,
    val month: String,
    val news: String,
    val num: Int,
    val safe_title: String,
    val title: String,
    val transcript: String,
    val year: String
)

val dummyComicDTOList = listOf(
    ComicDTO(
        alt = "I got banned from the county fair for handing out Helium-2 balloons. Apparently the instant massive plasma explosions violated some local ordinance or something.",
        day = "22",
        img = "https://imgs.xkcd.com/comics/physics_cost_saving_tips.png",
        link = "",
        month = "7",
        news = "",
        num = 2649,
        safe_title = "Physics Cost-Saving Tips",
        title = "Physics Cost-Saving Tips",
        transcript = "",
        year = "2022"
    ),
    ComicDTO(
        alt = "I got banned from the county fair for handing out Helium-2 balloons. Apparently the instant massive plasma explosions violated some local ordinance or something.",
        day = "22",
        img = "https://imgs.xkcd.com/comics/physics_cost_saving_tips.png",
        link = "",
        month = "7",
        news = "",
        num = 2649,
        safe_title = "Physics Cost-Saving Tips",
        title = "Physics Cost-Saving Tips",
        transcript = "",
        year = "2022"
    ),
    ComicDTO(
        alt = "I got banned from the county fair for handing out Helium-2 balloons. Apparently the instant massive plasma explosions violated some local ordinance or something.",
        day = "22",
        img = "https://imgs.xkcd.com/comics/physics_cost_saving_tips.png",
        link = "",
        month = "7",
        news = "",
        num = 2649,
        safe_title = "Physics Cost-Saving Tips",
        title = "Physics Cost-Saving Tips",
        transcript = "",
        year = "2022"
    ),
    ComicDTO(
        alt = "I got banned from the county fair for handing out Helium-2 balloons. Apparently the instant massive plasma explosions violated some local ordinance or something.",
        day = "22",
        img = "https://imgs.xkcd.com/comics/physics_cost_saving_tips.png",
        link = "",
        month = "7",
        news = "",
        num = 2649,
        safe_title = "Physics Cost-Saving Tips",
        title = "Physics Cost-Saving Tips",
        transcript = "",
        year = "2022"
    )
)