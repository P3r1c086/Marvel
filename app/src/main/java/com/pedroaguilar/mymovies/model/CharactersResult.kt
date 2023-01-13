package com.pedroaguilar.mymovies.model

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 18:30
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
data class CharactersResult(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)
