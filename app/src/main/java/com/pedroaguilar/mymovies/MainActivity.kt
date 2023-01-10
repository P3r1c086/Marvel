package com.pedroaguilar.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pedroaguilar.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Title1", "url1"),
                Movie("Title2", "url2"),
                Movie("Title3", "url3"),
                Movie("Title4", "url4"),
                Movie("Title5", "url5"),
                Movie("Title6", "url6"),
            )
        )
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy")
    }
}