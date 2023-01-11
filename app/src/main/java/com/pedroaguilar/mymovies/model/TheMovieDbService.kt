package com.pedroaguilar.mymovies.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 11/01/2023 at 12:52
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
interface TheMovieDbService {
    //establecer el end point con @get
    @GET("v1/public/characters")
    fun listPopularMovies(@Query("api_Key") apiKey: String): Call<Data>

}