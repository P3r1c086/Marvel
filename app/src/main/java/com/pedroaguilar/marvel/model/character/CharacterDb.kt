package com.pedroaguilar.marvel.model.character

import android.os.Parcelable
import com.pedroaguilar.marvel.model.comic.Comics
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/**
 * Proyect: Marvel
 * From: com.pedroaguilar.marvel.model
 * Create by Pedro Aguilar Fernández on 13/01/2023 at 18:34
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
@Parcelize
data class CharacterDb(
    val id: Int,
    var name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: @RawValue Series,
    val stories: @RawValue Stories,
    val events: @RawValue Events,
    val urls: @RawValue List<Url>
) : Parcelable
