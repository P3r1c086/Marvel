package com.pedroaguilar.mymovies.model

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 18:34
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
data class CharacterDb(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: Series,
    val stories: Stories,
    val events: Events,
    val urls: List<Url>
)
