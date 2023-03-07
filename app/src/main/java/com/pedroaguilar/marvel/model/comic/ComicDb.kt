package com.pedroaguilar.marvel.model.comic

import android.media.Image
import android.os.Parcelable
import com.pedroaguilar.marvel.model.character.Thumbnail
import com.pedroaguilar.marvel.model.character.Url
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.util.Date

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.model
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 13:16
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
@Parcelize
data class ComicDb(
    val id: Int,
    val title: String,
    val issueNumber: Double,
    val variantDescription: String,
    val description: String,
    val isbn: String,
    val upc: String,
    val diamondCode: String,
    val ean: String,
    val issn: String,
    val format: String,
    val pageCount: Int,
    val textObjects: ArrayList<TextObject>,
    val resourceURI: String,
    val urls: ArrayList<Url>,
    val series: SeriesSummary,
    val variants: ArrayList<ComicSummary>,
    val collections: ArrayList<ComicSummary>,
    val collectedIssues: ArrayList<ComicSummary>,
    val prices: ArrayList<ComicPrice>,
    val thumbnail: Thumbnail,
    val images: List<Thumbnail>,
    val creators: CreatorList,
    val characters: CharacterList,
    val stories: StoryList,
    val events: EventList,
) : Parcelable
