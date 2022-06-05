package com.movilesi.proyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movilesi.proyectofinal.databinding.ItemProductosBinding
import org.json.JSONArray
import org.json.JSONObject

class RandomAdapter (private val productos: JSONArray): RecyclerView.Adapter<RandomAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomAdapter.MainHolder {
        val binding = ItemProductosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: RandomAdapter.MainHolder, position: Int) {
        holder.render(productos.getJSONObject(position))
    }

    override fun getItemCount(): Int = productos.length()

    class MainHolder(val binding: ItemProductosBinding): RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: JSONObject){
            binding.tvTitle.setText(pokemon.getString("title"))
            binding.tvPrice.setText(pokemon.getString("price"))
            binding.tvDescription.setText(pokemon.getString("description"))
            binding.tvCategory.setText(pokemon.getString("category"))
            binding.tvRate.setText(pokemon.getString("rate"))
        }
    }
}