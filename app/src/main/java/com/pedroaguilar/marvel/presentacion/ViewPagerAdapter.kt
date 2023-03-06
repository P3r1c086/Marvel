package com.pedroaguilar.marvel.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pedroaguilar.marvel.presentacion.characterUI.CharacterFragment
import com.pedroaguilar.marvel.presentacion.comicUI.ComicFragment

/**
 * Proyect: My Movies
 * From: com.pedroaguilar.marvel
 * Create by Pedro Aguilar Fernández on 05/03/2023 at 11:03
 * More info: linkedin.com/in/pedro-aguilar-fernández-167753140
 * All rights reserved 2023
 **/
class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    companion object{
        private const val ARG_OBJECT = "object"
    }
    override fun getItemCount(): Int = 3 //cantidad de fragment que se van a inflar

    override fun createFragment(position: Int): Fragment {
        return when(position + 1){
            1 -> {
                val fragment = CharacterFragment()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment
            }
            2 -> {
                val fragment = ComicFragment()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment
            }
            3 -> { val fragment = CharacterFragment()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment}

            else -> CharacterFragment()
        }
//        val fragment = CharacterFragment() //fragment donde se va a ir
//        //argumentos que se le van a pasar a ese fragment
//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, position + 1)
//        }
//        return fragment
    }
}