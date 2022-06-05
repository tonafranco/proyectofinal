package com.movilesi.proyectofinal.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitBuilder {

    @GET("{id}")
    fun getProductById(@Path("id") id:String): Call<ProductoEntry>

    companion object{
        private val BASE_URL ="https://fakestoreapi.com/products"

        fun create(): RetrofitBuilder{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitBuilder::class.java)
        }
    }
}