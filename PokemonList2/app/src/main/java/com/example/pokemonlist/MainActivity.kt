package com.example.pokemonlist

import ListPokemonAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var pokemon_list: RecyclerView
    private var list = ArrayList<Pokemon>() // create an empty ArrayList to store Pokemon objects
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemon_list = findViewById(R.id.pokemon_list)
        pokemon_list.setHasFixedSize(true)

        list.addAll(getListPokemon()) // add Pokemon objects to the list
        showRecyclerList() // display the list of Pokemon using RecyclerView

    }
    private fun showSelectedPokemon(pokemon: Pokemon) {
        Toast.makeText(this, "Kamu memilih " + pokemon.name, Toast.LENGTH_SHORT).show()
    }
    private fun getListPokemon(): ArrayList<Pokemon> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPokemon = ArrayList<Pokemon>()
        for (i in dataName.indices) {
            val pokemon = Pokemon(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPokemon.add(pokemon)
        }
        return listPokemon
    }

    private fun showRecyclerList() {
        pokemon_list.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ListPokemonAdapter(list)
        pokemon_list.adapter = listPokemonAdapter
        listPokemonAdapter.setOnItemClickCallback(object : ListPokemonAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pokemon) {
                showSelectedPokemon(data)
            }
        })
    }
}
