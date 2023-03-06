package com.pedroaguilar.marvel.model.comic

import com.pedroaguilar.marvel.servicios.TheComicsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 12:56
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
object ComicsClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TheComicsService::class.java)
}