package com.pedroaguilar.marvel.model.serie

import com.pedroaguilar.marvel.servicios.TheSerieDbService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.serie
 * Create by Pedro Aguilar Fernández on 07/03/2023 at 13:38
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
object SerieDbClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TheSerieDbService::class.java)
}