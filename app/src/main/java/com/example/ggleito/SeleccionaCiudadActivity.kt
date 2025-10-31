package com.example.ggleito

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivitySeleccionaCiudadBinding

class SeleccionaCiudadActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeleccionaCiudadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySeleccionaCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pantalla_seleccion_ciudad)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val departamentos = mapOf(
            binding.departamentoSantaCruz to Pair(R.drawable.santacruz, "Santa Cruz"),
            binding.departamentoLaPaz to Pair(R.drawable.lapaz, "La Paz"),
            binding.departamentoSucre to Pair(R.drawable.sucre, "Sucre"),
            binding.departamentoPotosi to Pair(R.drawable.potosi, "Potosí"),
            binding.departamentoBeni to Pair(R.drawable.beni, "Beni"),
            binding.departamentoTarija to Pair(R.drawable.tarija, "Tarija"),
            binding.departamentoCochabamba to Pair(R.drawable.cochabamba, "Cochabamba"),
            binding.departamentoOruro to Pair(R.drawable.oruro, "Oruro"),
            binding.departamentoPando to Pair(R.drawable.pando, "Pando")
        )

        for ((button, data) in departamentos) {
            val (imageResId, nombreDepartamento) = data
            button.setOnClickListener {
                val intent = Intent(this, DepartamentoSeleccionadoActivity::class.java)
                intent.putExtra("imagen_departamento", imageResId)
                intent.putExtra("nombre_departamento", nombreDepartamento)
                startActivity(intent)
            }
        }
    }
}
