package com.test.pokedex.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        initializeCoponents()
        initializeListeners()
      //  initializeData()
    }

    fun initializeCoponents(){

    }

    fun initializeListeners(){
    }

    fun initializeData(){
        Ion.with(context)
            .load("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=964")
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    Log.i("Output", result.getAsJsonArray("results").size().toString())

                    data = result.getAsJsonArray("results")

                    
                }
            }
    }
}
