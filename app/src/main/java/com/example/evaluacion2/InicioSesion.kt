package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioSesion : AppCompatActivity() {

    private val CORREO_VALIDO = "usuario@example.com"
    private val CONTRASENA_VALIDA = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_sesion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val registrarseTextView = findViewById<TextView>(R.id.registrarse)
        registrarseTextView.setOnClickListener {
            val intent = Intent(this, registro::class.java) // Cambia RegistroActivity al nombre de tu actividad de registro en Java
            startActivity(intent)
        }

        val editTextCorreo = findViewById<EditText>(R.id.correo)
        val editTextContrasena = findViewById<EditText>(R.id.contraseña)
        val botonIngresar = findViewById<Button>(R.id.login_button)

        botonIngresar.setOnClickListener {
            val correoIngresado = editTextCorreo.text.toString()
            val contrasenaIngresada = editTextContrasena.text.toString()

            if (correoIngresado.isEmpty() || contrasenaIngresada.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            } else if (correoIngresado == CORREO_VALIDO && contrasenaIngresada == CONTRASENA_VALIDA) {
                val intent = Intent(this, EntrenamientoActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
