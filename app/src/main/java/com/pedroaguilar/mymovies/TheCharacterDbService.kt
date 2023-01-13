package com.pedroaguilar.mymovies

import com.pedroaguilar.mymovies.model.CharactersResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 18:18
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
interface TheCharacterDbService {
    @GET("characters")
    fun listPopularCharacters(
        @Query("ts") ts: Int,
        @Query("apy_key_public") apiKeyPublic: String,
        @Query("hash")hash: String
    ): Call<CharactersResult>
}