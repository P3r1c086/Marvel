package com.pedroaguilar.marvel.model.comic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.comic
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 13:34
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
@Parcelize
data class Url(
    val type: String,
    val url: String
) : Parcelable
