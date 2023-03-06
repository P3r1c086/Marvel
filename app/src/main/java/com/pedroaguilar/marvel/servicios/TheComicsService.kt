package com.pedroaguilar.marvel.servicios

import com.pedroaguilar.marvel.model.comic.ComicsResult
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 12:58
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
interface TheComicsService {
    @GET("comics")
    suspend fun listPopularComics(
        @Query("ts") ts: String,
        @Query("apikey") apiKeyPublic: String,
        @Query("hash")hash: String,
//        @Query("limit") limit: String
    ): ComicsResult
}