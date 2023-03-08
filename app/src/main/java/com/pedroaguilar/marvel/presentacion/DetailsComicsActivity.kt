package com.pedroaguilar.marvel.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.pedroaguilar.marvel.R
import com.pedroaguilar.marvel.databinding.ActivityDetailsComicsBinding
import com.pedroaguilar.marvel.model.comic.ComicDb

class DetailsComicsActivity : AppCompatActivity() {

    //companion object es un objeto que comparten todas las instancias de esta clase
    companion object{
        const val EXTRA_COMIC = "DetailsComicsActivity:comic"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailsComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val comic = intent.getParcelableExtra<ComicDb>(EXTRA_COMIC)
        if (comic != null){
            title = comic.title

            Glide.with(this)
                .load("${comic.thumbnail.path.replace("http","https")}.${comic.thumbnail.extension}")
                .into(binding.imgBackdrop)
            if (comic.description.isEmpty()){
                binding.tvSummary.text = "Description not available"
            }else{
                binding.tvSummary.text = comic.description
            }
            bindDetailInfo(binding.tvDetailInfo, comic)
        }
    }
    private fun bindDetailInfo(tvDetailInfo: TextView, comic: ComicDb){
        tvDetailInfo.text = buildSpannedString {
            bold { append("Numero de páginas: ") }
            appendLine(comic.pageCount.toString())

            bold { append("ID: ") }
            appendLine(comic.id.toString())
        }
    }
}