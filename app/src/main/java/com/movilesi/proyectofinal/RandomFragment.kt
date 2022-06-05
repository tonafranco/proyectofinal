package com.movilesi.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.movilesi.proyectofinal.databinding.FragmentRandomBinding
import org.json.JSONObject


class RandomFragment : Fragment() {

    private lateinit var queue: RequestQueue
    private lateinit var binding: FragmentRandomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomBinding.inflate(layoutInflater)
        queue = Volley.newRequestQueue(context)
        getProductList(5)
        //return inflater.inflate(R.layout.fragment_random, container, false)
        return binding.root
    }

    fun getProductList(listAmount: Int){
        val url = "https://fakestoreapi.com/products?limit=${listAmount}"

        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
            Log.i("JSONRESPONSE", response.getJSONArray("results").toString())

            binding.rvProductRandom.adapter = RandomAdapter(response.getJSONArray("results"))
        },
            Response.ErrorListener { error ->
                Log.w("JSONRESPONSE", error.message as String)
            })

        queue.add(jsonRequest)
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll("Stopped")
    }

}