package com.pedroaguilar.marvel.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.pedroaguilar.marvel.databinding.ActivityDetailBinding
import com.pedroaguilar.marvel.model.character.CharacterDb

class DetailActivity : AppCompatActivity() {

    //companion object es un objeto que comparten todas las instancias de esta clase
    companion object{
        const val EXTRA_CHARACTER = "DetailActivity:character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //parcelable es una especie de serializacion existente en android, que nos permite convertir
        // nuestro objeto a elementos mas sencillos, para luego porder pasarlos a traves de los intents o bundles

        val character = intent.getParcelableExtra<CharacterDb>(EXTRA_CHARACTER)
        if (character != null){
            //para que el nombre del personaje aparezca como titulo en la appBar
            title = character.name

            Glide.with(this)
                .load("${character.thumbnail.path.replace("http","https")}.${character.thumbnail.extension}")
                .into(binding.imgBackdrop)
            //la respuesta del servidor trae el campo descripcion vacio
//            binding.tvSummary.text = character.description
            if (character.description.isEmpty()){
                binding.tvSummary.text = "Description not available"
            }else{
                binding.tvSummary.text = character.description + character.description +character.description +character.description +character.description +character.description +character.description +character.description
            }

            bindDetailInfo(binding.tvDetailInfo, character)
        }
    }

    private fun bindDetailInfo(tvDetailInfo: TextView, character: CharacterDb) {
        tvDetailInfo.text = buildSpannedString {
            bold { append("Modificado: ") }
            appendLine(character.modified)

            bold { append("ID: ") }
            appendLine(character.id.toString())
        }
    }
}