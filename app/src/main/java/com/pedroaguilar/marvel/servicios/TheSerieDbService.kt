package com.pedroaguilar.marvel.servicios

import com.pedroaguilar.marvel.model.serie.SeriesResult
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.servicios
 * Create by Pedro Aguilar Fernández on 07/03/2023 at 13:39
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
interface TheSerieDbService {
    @GET("series")
    suspend fun listPopularSeries(
        @Query("ts") ts: String,
        @Query("apikey") apiKeyPublic: String,
        @Query("hash")hash: String,
        @Query("limit") limit: String
    ): SeriesResult
}