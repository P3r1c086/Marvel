package com.pedroaguilar.marvel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroaguilar.marvel.databinding.ViewMovieItemBinding
import com.pedroaguilar.marvel.model.comic.ComicDb

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 13:13
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
class ComicsAdapter (
    var comics: List<ComicDb>,
    private val comicClickedLsitener: (ComicDb) -> Unit)
    :
    RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

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
        val comic = comics[position]
        holder.bind(comic)//movie es un objeto pelicula en una posicion concreta
        //asignar el onClikListener al adapter. El holder guarda la vista que le pasamos
        // por argumento al ViewHolder en la propiedad itemView
        holder.itemView.setOnClickListener { comicClickedLsitener(comic) }
    }

    /**
     * Devuelve el numero de elementos que tiene el adapter
     */
    override fun getItemCount(): Int = comics.size

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(comic: ComicDb){
            binding.tvTitleMovie.text = comic.title
            Glide.with(binding.root.context)
                .load("${comic.thumbnail.path.replace("http","https")}.${comic.thumbnail.extension}")
                .into(binding.imgCharacter)
        }
    }


}