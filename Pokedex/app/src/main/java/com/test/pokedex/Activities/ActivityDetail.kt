package com.test.pokedex.Activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.test.pokedex.Adapters.AdapterDetail
import com.test.pokedex.Adapters.AdapterList
import com.test.pokedex.R
import kotlinx.android.synthetic.main.activity_detail.*

class ActivityDetail : AppCompatActivity() {
    private var context: Context = this

    private lateinit var data: JsonArray
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AdapterDetail

    private lateinit var num_pokemon: TextView
    private lateinit var n_pokemon: TextView
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
        n_pokemon = this.findViewById(R.id.name_pokemon);
        num_pokemon.text = id;
        url = "https://pokeapi.co/api/v2/pokemon/"+id+"/";
        Toast.makeText(this@ActivityDetail,  url, Toast.LENGTH_LONG).show()
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

                cargarinformacion()
                }
            }
    }

    fun cargarinformacion(){

        var item: JsonObject = data.get(1).asJsonObject
        Toast.makeText(this@ActivityDetail,  "hola", Toast.LENGTH_LONG).show()
        n_pokemon.text = item.get("name").asString

    }
}
