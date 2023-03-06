package com.pedroaguilar.marvel.model.comic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.comic
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 13:38
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/

@Parcelize
data class ComicDate(
    val type: String,
    val date: Date
) : Parcelable
