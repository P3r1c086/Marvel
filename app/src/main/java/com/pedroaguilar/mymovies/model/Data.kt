package com.pedroaguilar.mymovies.model

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<MovieDb>,
    val total: Int
)