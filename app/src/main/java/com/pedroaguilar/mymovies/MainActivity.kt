package com.pedroaguilar.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pedroaguilar.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //al adapter se le pasa una lista y en este caso concreto, un listener
        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Title1", "https://loremflickr.com/320/240?lock=1"),
                Movie("Title2", "https://loremflickr.com/320/240?lock=2"),
                Movie("Title3", "https://loremflickr.com/320/240?lock=3"),
                Movie("Title4", "https://loremflickr.com/320/240?lock=4"),
                Movie("Title5", "https://loremflickr.com/320/240?lock=5"),
                Movie("Title6", "https://loremflickr.com/320/240?lock=6"),
            )
        ){ movie -> //esta lamnda representa el listener
            //si solo pongo this tomaria el contexto del objeto que se esta creando aqui
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy")
    }
}