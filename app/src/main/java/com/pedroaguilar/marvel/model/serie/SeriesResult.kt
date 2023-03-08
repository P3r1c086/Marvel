package com.pedroaguilar.marvel.model.serie

import com.pedroaguilar.marvel.model.serie.Data

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.serie
 * Create by Pedro Aguilar Fernández on 07/03/2023 at 13:41
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
data class SeriesResult(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)
