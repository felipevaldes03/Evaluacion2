package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inicioentrenamiento : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var timer: CountDownTimer
    private var isTimerRunning = false
    private var timeInSeconds: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicioentrenamiento)

        // Setup para el edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización del TextView del cronómetro
        timerTextView = findViewById(R.id.timer)

        // Iniciar el contador
        startTimer()

        // Encuentra el botón Detener y configura el listener
        val buttonDetener: Button = findViewById(R.id.button_detener)
        buttonDetener.setOnClickListener {
            // Detener el cronómetro
            stopTimer()
            // Regresar a la actividad de Entrenamiento
            val intent = Intent(this, EntrenamientoActivity::class.java)
            startActivity(intent)
            finish() // Cierra esta actividad
        }
    }

    private fun startTimer() {
        isTimerRunning = true
        timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeInSeconds++
                updateTimerText()
            }

            override fun onFinish() {
                isTimerRunning = false
            }
        }.start()
    }

    private fun stopTimer() {
        if (isTimerRunning) {
            timer.cancel()
            isTimerRunning = false
        }
    }

    private fun updateTimerText() {
        val hours = timeInSeconds / 3600
        val minutes = (timeInSeconds % 3600) / 60
        val seconds = timeInSeconds % 60

        val timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds)
        timerTextView.text = "Tiempo: $timeString"
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer() // Asegúrate de detener el cronómetro al destruir la actividad
    }
}
