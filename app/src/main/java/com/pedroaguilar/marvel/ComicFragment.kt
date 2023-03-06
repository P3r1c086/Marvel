package com.pedroaguilar.marvel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.pedroaguilar.marvel.databinding.FragmentComicBinding
import com.pedroaguilar.marvel.model.comic.ComicDb
import com.pedroaguilar.marvel.model.comic.ComicsClient
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class ComicFragment : Fragment() {

    companion object{
        private const val ARG_OBJECT = "object"
    }

    private lateinit var binding: FragmentComicBinding

    val ts = Timestamp(System.currentTimeMillis()).time.toString()
    val apyKeyPublic = "76c50e571bdbf850b8df6384d24b6670"
    val apyKeyPrivate = "9728204088bf033acdd0e62ab60b0cf6b91ef0c9"

    //esta lamnda representa el listener
    private val comicsAdapter = ComicsAdapter(emptyList()){ comic ->  navigateTo(comic)}
    //al adapter se le pasa una lista y en este caso concreto, un listener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            requestPopularComic()
            binding.recycler.adapter = comicsAdapter
        }
    }

    private fun navigateTo(comic: ComicDb) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_CHARACTER, comic)
        startActivity(intent)
    }

    @SuppressLint("MissingPermission")
    private fun requestPopularComic() {
        doRequestPopularComics()
    }

    private fun doRequestPopularComics() {
        lifecycleScope.launch {
            val popularComics = ComicsClient.service.listPopularComics(
                ts,
                apyKeyPublic,
                hash()//,
//                "20"
            )
            comicsAdapter.comics = popularComics.data.results
            comicsAdapter.notifyDataSetChanged()
        }
    }

    private fun hash(): String{
        val input = "$ts$apyKeyPrivate$apyKeyPublic"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}