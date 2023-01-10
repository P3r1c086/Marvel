package com.pedroaguilar.mymovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroaguilar.mymovies.databinding.ViewMovieItemBinding

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies
 * Create by Pedro Aguilar Fernández on 10/01/2023 at 13:29
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/

class MoviesAdapter(
    private val movies: List<Movie>,
    private val movieClickedLsitener: (Movie) -> Unit)
    :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

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
        val movie = movies[position]
        holder.bind(movie)//movie es un objeto pelicula en una posicion concreta
        //asignar el onClikListener al adapter. El holder guarda la vista que le pasamos
        // por argumento al ViewHolder en la propiedad itemView
        holder.itemView.setOnClickListener { movieClickedLsitener(movie) }
    }

    /**
     * Devuelve el numero de elementos que tiene el adapter
     */
    override fun getItemCount(): Int = movies.size

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.tvTitleMovie.text = movie.title
            Glide.with(binding.root.context)
                .load(movie.cover)
                .into(binding.imgCover)
        }
    }


}