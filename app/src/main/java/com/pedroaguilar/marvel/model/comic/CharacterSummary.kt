package com.pedroaguilar.marvel.model.comic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model.comic
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 13:50
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
@Parcelize
data class CharacterSummary(
    val resourceURI: String,
    val name: String,
    val role: String
) : Parcelable
