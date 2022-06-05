package com.movilesi.proyectofinal.remote

import com.google.gson.annotations.SerializedName

data class ProductoEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("rating")
    val rating: List<RatingEntry>
)

data class RatingEntry(
    @SerializedName("rate")
    val rate: Int,
    @SerializedName("count")
    val count: Int
)
