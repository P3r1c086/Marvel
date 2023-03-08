package com.pedroaguilar.marvel.presentacion.serieUI

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.pedroaguilar.marvel.databinding.FragmentSerieBinding
import com.pedroaguilar.marvel.model.serie.SerieDb
import com.pedroaguilar.marvel.model.serie.SerieDbClient
import com.pedroaguilar.marvel.presentacion.DetailsSeriesActivity
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class SerieFragment : Fragment() {

    companion object{
        private const val ARG_OBJECT = "object"
    }

    private lateinit var binding: FragmentSerieBinding

    val ts = Timestamp(System.currentTimeMillis()).time.toString()
    val apyKeyPublic = "76c50e571bdbf850b8df6384d24b6670"
    val apyKeyPrivate = "9728204088bf033acdd0e62ab60b0cf6b91ef0c9"

    private val seriesAdapter = SeriesAdapter(emptyList()){ serie -> navigateTo(serie)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSerieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            requestPopularSerie()
            binding.recycler.adapter = seriesAdapter
        }
    }

    private fun navigateTo(serie: SerieDb) {
        val intent = Intent(activity, DetailsSeriesActivity::class.java)
        intent.putExtra(DetailsSeriesActivity.EXTRA_SERIE, serie)
        startActivity(intent)
    }

    @SuppressLint("MissingPermission")
    private fun requestPopularSerie() {
        doRequestPopularSeries()
    }

    private fun doRequestPopularSeries() {
        lifecycleScope.launch {
            val popularSeries = SerieDbClient.service.listPopularSeries(
                ts,
                apyKeyPublic,
                hash(),
                "20"
            )
            seriesAdapter.series = popularSeries.data.results
            seriesAdapter.notifyDataSetChanged()
        }
    }

    private fun hash(): String{
        val input = "$ts$apyKeyPrivate$apyKeyPublic"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}