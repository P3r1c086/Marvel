package com.pedroaguilar.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pedroaguilar.mymovies.databinding.ActivityMainBinding
import com.pedroaguilar.mymovies.model.CharacterDbClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //al adapter se le pasa una lista y en este caso concreto, un listener
        binding.recycler.adapter = CharactersAdapter(
            listOf(
                Character("Title1", "https://loremflickr.com/320/240?lock=1"),
                Character("Title2", "https://loremflickr.com/320/240?lock=2"),
                Character("Title3", "https://loremflickr.com/320/240?lock=3"),
                Character("Title4", "https://loremflickr.com/320/240?lock=4"),
                Character("Title5", "https://loremflickr.com/320/240?lock=5"),
                Character("Title6", "https://loremflickr.com/320/240?lock=6"),
            )
        ){ character -> //esta lamnda representa el listener
            //si solo pongo this tomaria el contexto del objeto que se esta creando aqui
            Toast.makeText(this@MainActivity, character.name, Toast.LENGTH_SHORT).show()
        }

        thread {
            val apyKeyPublic = getString(R.string.api_key_public)
            val popularCharacters = CharacterDbClient.service.listPopularCharacters(
                1,
                apyKeyPublic,
                "1" + getString(R.string.api_key_private) + getString(R.string.api_key_public))
            val body = popularCharacters.execute().body()
            if (body != null){
                Log.d("MainActivity", "Characters count: ${body.data.results.size}")
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy")
    }
}