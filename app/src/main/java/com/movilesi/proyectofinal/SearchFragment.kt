package com.movilesi.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.movilesi.proyectofinal.databinding.FragmentSearchBinding
import com.movilesi.proyectofinal.remote.ProductoEntry
import com.movilesi.proyectofinal.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        var number = ""
        binding.btnProductSearch.setOnClickListener {
            number = binding.etProductSearch.text.toString()

        }

        val retrofit = RetrofitBuilder.create().getProductById(number)

        retrofit.enqueue(object: Callback<ProductoEntry> {
            override fun onResponse(call: Call<ProductoEntry>, response: Response<ProductoEntry>) {
                Log.d("retrofitresponse", "res: ${response.body()}")
                //binding.tvNombre.setText(response.body()?.title)
                Log.d("retrofitresponse", "name: ${response.body()?.title}")
                Log.d("retrofitresponse", "name: ${response.body()?.price}")
                Log.d("retrofitresponse", "name: ${response.body()?.description}")
                Log.d("retrofitresponse", "name: ${response.body()?.category}")
                Log.d("retrofitresponse", "name: ${response.body()?.image}")

                val ratingArray = response.body()?.rating
                if (ratingArray != null){
                    Log.d("retrofitresponse", "type: ${ratingArray[0].rate}")
                    Log.d("retrofitresponse", "type: ${ratingArray[1].count}")
                }

            }
            override fun onFailure(call: Call<ProductoEntry>, t:Throwable){
                Log.e("retrofitresponse", "error: ${t.message}")
            }
        })


        return binding.root
    }



}