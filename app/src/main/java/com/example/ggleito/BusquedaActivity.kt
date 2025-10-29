package com.example.ggleito

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityBusquedaBinding

class BusquedaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusquedaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBusquedaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.busqueda_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.bottonFiltrar.setOnClickListener {
            mostrarOcultarFiltros()
        }
    }

    private fun mostrarOcultarFiltros() {
        val estanOcultos = binding.textViewSalario.visibility == View.INVISIBLE
        val nuevoEstado = if (estanOcultos) View.VISIBLE else View.INVISIBLE
        binding.textViewSalario.visibility = nuevoEstado
        binding.textViewSalario20005000.visibility = nuevoEstado
        binding.textViewSalario50008000.visibility = nuevoEstado
        binding.textViewSalarioMas8000.visibility = nuevoEstado
        binding.textViewHorario.visibility = nuevoEstado
        binding.textViewHorarioMedioTiempo.visibility = nuevoEstado
        binding.textViewHorarioTiempoCompleto.visibility = nuevoEstado
    }
}
