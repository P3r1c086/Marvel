package com.pedroaguilar.marvel.presentacion.serieUI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroaguilar.marvel.databinding.ViewMovieItemBinding
import com.pedroaguilar.marvel.model.serie.SerieDb

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel.presentacion.serieUI
 * Create by Pedro Aguilar Fernández on 07/03/2023 at 13:48
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
class SeriesAdapter (
    var series: List<SerieDb>,
            private val serieClickedListener: (SerieDb) -> Unit)
    :
        RecyclerView.Adapter<SeriesAdapter.ViewHolder>(){

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
        val serie = series[position]
        holder.bind(serie)//movie es un objeto pelicula en una posicion concreta
        //asignar el onClikListener al adapter. El holder guarda la vista que le pasamos
        // por argumento al ViewHolder en la propiedad itemView
        holder.itemView.setOnClickListener { serieClickedListener(serie) }
    }

    /**
     * Devuelve el numero de elementos que tiene el adapter
     */
    override fun getItemCount(): Int = series.size

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(serie: SerieDb){
            binding.tvTitleMovie.text = serie.title
            Glide.with(binding.root.context)
                .load("${serie.thumbnail.path.replace("http","https")}.${serie.thumbnail.extension}")
                .into(binding.imgCharacter)
        }
    }
}