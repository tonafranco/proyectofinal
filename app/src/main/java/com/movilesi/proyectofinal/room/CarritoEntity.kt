package com.movilesi.proyectofinal.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class CarritoEntity(
    @ColumnInfo(name = "product_id") @PrimaryKey val pdid: String,
    @ColumnInfo(name = "user_name") val name: String,
    val product_name: Double,
    val price: Double,
    val description: String,
    val rate: Double
)

