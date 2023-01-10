package com.pedroaguilar.mymovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedroaguilar.mymovies.databinding.ViewMovieItemBinding

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.mymovies
 * Create by Pedro Aguilar Fernández on 10/01/2023 at 13:29
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
class MoviesAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

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
        holder.bind(movies[position])
    }

    /**
     * Devuelve el numero de elementos que tiene el adapter
     */
    override fun getItemCount(): Int = movies.size

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.tvTitleMovie.text = movie.title
        }
    }


}