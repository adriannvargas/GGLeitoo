package com.example.ggleito

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeleccionaCiudadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selecciona_ciudad)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pantalla_seleccion_ciudad)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val departamentos = mapOf(
            R.id.departamento_santa_cruz to R.drawable.santacruz,
            R.id.departamento_la_paz to R.drawable.lapaz,
            R.id.departamento_sucre to R.drawable.sucre,
            R.id.departamento_potosi to R.drawable.potosi,
            R.id.departamento_beni to R.drawable.beni,
            R.id.departamento_tarija to R.drawable.tarija,
            R.id.departamento_cochabamba to R.drawable.cochabamba,
            R.id.departamento_oruro to R.drawable.oruro,
            R.id.departamento_pando to R.drawable.pando
        )

        for ((buttonId, imageResId) in departamentos) {
            val button = findViewById<ImageButton>(buttonId)
            button.setOnClickListener {
                val intent = Intent(this, DepartamentoSeleccionadoActivity::class.java)
                intent.putExtra("imagen_departamento", imageResId)
                startActivity(intent)
            }
        }
    }
}
