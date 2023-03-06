package com.pedroaguilar.marvel

import com.pedroaguilar.marvel.model.character.CharactersResult
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
    suspend fun listPopularCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKeyPublic: String,
        @Query("hash")hash: String,
        @Query("limit") limit: String
    ): CharactersResult
}