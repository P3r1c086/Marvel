package com.pedroaguilar.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.pedroaguilar.marvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {//se va a instanciar una vez se necesite
        ViewPagerAdapter(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pager.adapter = adapter
        val tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.pager,
            TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
            when(position + 1){
                1 -> {
                    tab.text = "Personajes"                }
                2 -> {
                    tab.text = "Comics"
                }
                3 -> {
                    tab.text = "Series"
                }
            }
        })
        tabLayoutMediator.attach()
    }
}
