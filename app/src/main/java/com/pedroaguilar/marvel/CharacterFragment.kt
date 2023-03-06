package com.pedroaguilar.marvel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.pedroaguilar.marvel.databinding.FragmentCharacterBinding
import com.pedroaguilar.marvel.model.character.CharacterDb
import com.pedroaguilar.marvel.model.character.CharacterDbClient
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class CharacterFragment : Fragment() {

    companion object{
        private const val ARG_OBJECT = "object"
    }

    private lateinit var binding: FragmentCharacterBinding

    val ts = Timestamp(System.currentTimeMillis()).time.toString()
    val apyKeyPublic = "76c50e571bdbf850b8df6384d24b6670"
    val apyKeyPrivate = "9728204088bf033acdd0e62ab60b0cf6b91ef0c9"

    //esta lamnda representa el listener
    private val charactersAdapter = CharactersAdapter(emptyList()){ character ->  navigateTo(character)}
    //al adapter se le pasa una lista y en este caso concreto, un listener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            requestPopularCharacter()
            binding.recycler.adapter = charactersAdapter
        }

    }
    private fun navigateTo(character: CharacterDb) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_CHARACTER, character)
        startActivity(intent)
    }

    @SuppressLint("MissingPermission")
    private fun requestPopularCharacter() {
        doRequestPopularCharacters()
    }

    private fun doRequestPopularCharacters() {
        lifecycleScope.launch {
            val popularCharacters = CharacterDbClient.service.listPopularCharacters(
                ts,
                apyKeyPublic,
                hash(),
                "20"
            )
            charactersAdapter.characters = popularCharacters.data.results
            charactersAdapter.notifyDataSetChanged()
        }
    }

    private fun hash(): String{
        val input = "$ts$apyKeyPrivate$apyKeyPublic"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}