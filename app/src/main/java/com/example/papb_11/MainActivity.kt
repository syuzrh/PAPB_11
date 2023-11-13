package com.example.papb_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.papb_11.databinding.ActivityMainBinding
import com.example.papb_11.model.Hero
import com.example.papb_11.model.Rick
import com.example.papb_11.model.Superhero
import com.example.papb_11.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getSuperhero()
        val superherolist = ArrayList<Hero>()

        response.enqueue(object : retrofit2.Callback<Superhero> {
            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                for (i in response.body()!!.result!!){
                    superherolist.add(Hero(i?.image,i?.id,i?.title))
                }
                val adapter = SuperheroAdapter(superherolist)

                with(binding) {
                    recycler.adapter = adapter
                    recycler.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi Error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}