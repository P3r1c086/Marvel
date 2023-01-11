package com.pedroaguilar.mymovies.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 11/01/2023 at 12:59
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
object MovieDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TheMovieDbService::class.java)
}