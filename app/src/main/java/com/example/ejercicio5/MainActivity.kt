package com.example.ejercicio5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {




    lateinit var txtTitulo : TextView
    lateinit var spLenguaje : Spinner
    lateinit var txtDescription : TextView

    val lenguajes = arrayOf("PHP", "Java", "Kotlin", "Javascript", "C++", "Python")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTitulo = findViewById(R.id.txtTitulo)
        spLenguaje = findViewById(R.id.spLenguaje)
        txtDescription = findViewById(R.id.txtDescription)
        //Crear el adaptador
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lenguajes)
        spLenguaje.adapter = adaptador
        spLenguaje.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.v("App Spinner", "Seleccionaste uno mi hermano $position")
        val lenguaje = lenguajes[position]
        txtTitulo.text=lenguaje
        val description = when(lenguaje){
            "PHP"-> "Es un lenguaje para la creacion de paginas web"
            "Java" -> "Es un lenguaje orientado a objetos"
            "Kotlin" -> "Lenguaje para aplicaciones de android"
            "Javascript" -> "Se utiliza para el lado del cliente de las paginas web"
            "C++" -> "Extiende el lenguaje de programacion C"
            "Python" -> "Lenguaje para creacion de IA"
            else -> "No se ha definido"
        }
        txtDescription.text = description
        //Log.w("App Spinner", "$lenguaje")
       // Log.w("App Spinner", "${view!!.id}")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}