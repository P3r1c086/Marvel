package com.pedroaguilar.mymovies.model

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 19:05
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterDb>
)
