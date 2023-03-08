package com.pedroaguilar.marvel.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.pedroaguilar.marvel.databinding.ActivityDetailsSeriesBinding
import com.pedroaguilar.marvel.model.serie.SerieDb

class DetailsSeriesActivity : AppCompatActivity() {

    //companion object es un objeto que comparten todas las instancias de esta clase
    companion object{
        const val EXTRA_SERIE = "DetailsSeriesActivity:serie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailsSeriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val serie = intent.getParcelableExtra<SerieDb>(EXTRA_SERIE)
        if (serie != null){
            title = serie.title

            Glide.with(this)
                .load("${serie.thumbnail.path.replace("http","https")}.${serie.thumbnail.extension}")
                .into(binding.imgBackdrop)
            if (serie.description.isEmpty()){
                binding.tvSummary.text = "Description not available"
            }else{
                binding.tvSummary.text = serie.description
            }
            bindDetailInfo(binding.tvDetailInfo, serie)
        }
    }

    private fun bindDetailInfo(tvDetailInfo: TextView, serie: SerieDb){
        tvDetailInfo.text = buildSpannedString {
            bold { append("ID: ") }
            appendLine(serie.id.toString())

            bold { append("Año de inicio: ") }
            appendLine(serie.startYear.toString())

            bold { append("Año de fin: ") }
            appendLine(serie.endYear.toString())
        }
    }
}