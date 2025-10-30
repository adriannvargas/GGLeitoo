package com.example.ggleito

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DepartamentoSeleccionadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_departamento_seleccionado)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pantalla_departamento_seleccionado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView = findViewById<ImageView>(R.id.imagen_departamento)
        val btnSiguiente = findViewById<Button>(R.id.boton_siguiente)
        val imageResId = intent.getIntExtra("imagen_departamento", 0)
        if (imageResId != 0) {
            imageView.setImageResource(imageResId)
        }
        btnSiguiente.setOnClickListener {
            val intent = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intent)
        }
    }
}
