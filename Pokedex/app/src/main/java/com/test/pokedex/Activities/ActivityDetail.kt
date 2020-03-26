package com.test.pokedex.Activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonArray
import com.koushikdutta.ion.Ion
import com.test.pokedex.Adapters.AdapterList
import com.test.pokedex.R

class ActivityDetail : AppCompatActivity() {
    private var context: Context = this

    private lateinit var data: JsonArray
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AdapterList

    private lateinit var num_pokemon: TextView
    private lateinit var id:String
    private lateinit var url:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        manageintent()
        initializeCoponents()
        initializeListeners()
        initializeData()
    }

    fun manageintent(){


        if (intent != null) {
            id = intent.getStringExtra("ID")

        }
    }

    fun initializeCoponents(){
        num_pokemon = this.findViewById(R.id.id_pokemon);
        num_pokemon.text = id;
        url = "https://pokeapi.co/api/v2/pokemon/"+id+"";
    }

    fun initializeListeners(){
    }

    fun initializeData(){
        Ion.with(context)
            .load(url)
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    Log.i("Output", result.getAsJsonArray("results").size().toString())

                    data = result.getAsJsonArray("results")


                }
            }
    }
}
