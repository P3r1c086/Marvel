package com.pedroaguilar.marvel.model.serie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.serie
 * Create by Pedro Aguilar Fernández on 07/03/2023 at 13:44
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String,
) : Parcelable
