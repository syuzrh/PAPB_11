package com.example.papb_11.network

import com.example.papb_11.model.Rick
import com.example.papb_11.model.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("data.php")
    fun getSuperhero(): Call<Superhero>
}