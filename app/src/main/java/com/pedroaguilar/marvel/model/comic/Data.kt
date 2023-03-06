package com.pedroaguilar.marvel.model.comic

import java.io.Serializable

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.comic
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 14:33
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ComicDb>
): Serializable
