package com.pedroaguilar.marvel.model.comic



/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 13:02
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
data class ComicsResult(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)
