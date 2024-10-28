package com.example.evaluacion2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class perfildatos : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfildatos)

        // Referenciamos cada TextView en la interfaz
        val nombreTextView = findViewById<TextView>(R.id.nombres)
        val apellidoPaternoTextView = findViewById<TextView>(R.id.apellido_paterno)
        val apellidoMaternoTextView = findViewById<TextView>(R.id.apellido_materno)
        val edadTextView = findViewById<TextView>(R.id.edad)
        val pesoTextView = findViewById<TextView>(R.id.peso)
        val alturaTextView = findViewById<TextView>(R.id.altura)

        try {
            // Recibimos cada dato del Intent
            val nombre = intent.getStringExtra("nombre") ?: "No disponible"
            val apellidoPaterno = intent.getStringExtra("apellidoPaterno") ?: "No disponible"
            val apellidoMaterno = intent.getStringExtra("apellidoMaterno") ?: "No disponible"
            val edad = intent.getStringExtra("edad") ?: "No disponible"
            val peso = intent.getStringExtra("peso") ?: "No disponible"
            val altura = intent.getStringExtra("altura") ?: "No disponible"

            // Asignamos cada dato al TextView correspondiente
            nombreTextView.text = nombre
            apellidoPaternoTextView.text = apellidoPaterno
            apellidoMaternoTextView.text = apellidoMaterno
            edadTextView.text = edad
            pesoTextView.text = peso
            alturaTextView.text = altura

        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            Toast.makeText(this, "Error al recibir los datos", Toast.LENGTH_SHORT).show()
        }

        // Configuración del botón para continuar
        val btnContinuar: Button = findViewById(R.id.btn_datosContinuar)
        btnContinuar.setOnClickListener {
            val intent = Intent(this, EntrenamientoActivity::class.java)
            startActivity(intent)
        }
    }
}


