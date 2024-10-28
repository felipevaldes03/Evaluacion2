package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val nombreEditText = findViewById<EditText>(R.id.nombres)
        val apellidoPaternoEditText = findViewById<EditText>(R.id.apellido_paterno)
        val apellidoMaternoEditText = findViewById<EditText>(R.id.apellido_materno)
        val edadEditText = findViewById<EditText>(R.id.edad)
        val pesoEditText = findViewById<EditText>(R.id.peso)
        val alturaEditText = findViewById<EditText>(R.id.altura)
        val guardarButton = findViewById<Button>(R.id.btn_guardar)

        guardarButton.setOnClickListener {
            try {
                // Extraemos los valores de cada campo de texto
                val nombre = nombreEditText.text.toString()
                val apellidoPaterno = apellidoPaternoEditText.text.toString()
                val apellidoMaterno = apellidoMaternoEditText.text.toString()
                val edad = edadEditText.text.toString()
                val peso = pesoEditText.text.toString()
                val altura = alturaEditText.text.toString()

                // Verificamos que los campos obligatorios no estén vacíos
                if (nombre.isNotEmpty() && apellidoPaterno.isNotEmpty()) {
                    // Creamos el Intent con los datos a enviar
                    val intent = Intent(this, perfildatos::class.java).apply {
                        putExtra("nombre", nombre)
                        putExtra("apellidoPaterno", apellidoPaterno)
                        putExtra("apellidoMaterno", apellidoMaterno)
                        putExtra("edad", edad)
                        putExtra("peso", peso)
                        putExtra("altura", altura)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Faltan datos obligatorios", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
                Toast.makeText(this, "Error al enviar los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



