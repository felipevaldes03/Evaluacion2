package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EntrenamientoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_entrenamiento)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pantallaperfil: ImageButton = findViewById(R.id.btn_perfil) // Asegúrate de que este ID sea correcto
        pantallaperfil.setOnClickListener {
            val intent = Intent(this, perfildatos::class.java)
            startActivity(intent)
        }

        val iniciar: Button = findViewById(R.id.button_iniciar)
        iniciar.setOnClickListener {
            val intent = Intent(this, inicioentrenamiento::class.java)
            startActivity(intent)

        }
    }
}
