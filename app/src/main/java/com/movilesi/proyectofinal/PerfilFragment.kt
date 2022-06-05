package com.movilesi.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PerfilFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // val database = Firebase.database
        //val myRef = database.reference

        return inflater.inflate(R.layout.fragment_perfil, container, false)

/*
        myRef.child("users").child("usuario_1").setValue(User("tona","ToNi","oro",1))
        myRef.child("users").child("usuario_2").setValue(User("juan","JuanJo","platino",2))
        myRef.child("users").child("usuario_3").setValue(User("raul","RuLo","bronce",3))

        myRef.child("usuarios").child("1").get().addOnSuccessListener { response ->
            //TODO value
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse", "Error getting data", it)
        }

 */
    }


}