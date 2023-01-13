package com.pedroaguilar.mymovies.model

import com.pedroaguilar.mymovies.TheCharacterDbService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 19:44
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
object CharacterDbClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TheCharacterDbService::class.java)
}