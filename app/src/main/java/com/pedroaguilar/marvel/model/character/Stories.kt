package com.pedroaguilar.marvel.model.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies.model
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 19:22
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
@Parcelize
data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
) : Parcelable
