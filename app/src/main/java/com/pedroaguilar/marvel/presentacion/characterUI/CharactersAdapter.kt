package com.pedroaguilar.marvel.presentacion.characterUI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroaguilar.marvel.databinding.ViewMovieItemBinding
import com.pedroaguilar.marvel.model.character.CharacterDb

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies
 * Create by Pedro Aguilar Fernández on 10/01/2023 at 13:29
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/

class CharactersAdapter(
    var characters: List<CharacterDb>,
    private val characterClickedLsitener: (CharacterDb) -> Unit)
    :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    /**
     * Creara una nueva vista cuando el recyclerView se lo pida
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflamos el layout view_movie_item
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }


    /**
     * Actualizara las vistas cuando el recyclerView se lo pida
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)//movie es un objeto pelicula en una posicion concreta
        //asignar el onClikListener al adapter. El holder guarda la vista que le pasamos
        // por argumento al ViewHolder en la propiedad itemView
        holder.itemView.setOnClickListener { characterClickedLsitener(character) }
    }

    /**
     * Devuelve el numero de elementos que tiene el adapter
     */
    override fun getItemCount(): Int = characters.size

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: CharacterDb){
            binding.tvTitleMovie.text = character.name
            Glide.with(binding.root.context)
                .load("${character.thumbnail.path.replace("http","https")}.${character.thumbnail.extension}")
                .into(binding.imgCharacter)
        }
    }


}