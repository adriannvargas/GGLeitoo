package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityBusquedaBinding

class BusquedaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusquedaBinding
    val context : Context = this

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
        binding.iconoTrabajosPostulados.setOnClickListener {

            val intentCambioDePantallaPostulados =
                Intent(context, TrabajosPostuladosActivity::class.java)
            startActivity(intentCambioDePantallaPostulados)
        }
        binding.iconoHome.setOnClickListener {
            val intentVolverPantallaPrincipal = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentVolverPantallaPrincipal)
        }
        binding.iconoPerfil.setOnClickListener {

            val intentCambioDePantallaPerfilActivity = Intent(context, PantallaPerfilActivity::class.java)
            startActivity(intentCambioDePantallaPerfilActivity)
        }
    }

    private fun mostrarOcultarFiltros() {
        val estanOcultos = binding.textViewSalario.visibility == View.GONE
        val nuevoEstado = if (estanOcultos) View.VISIBLE else View.GONE
        binding.textViewSalario.visibility = nuevoEstado
        binding.textViewSalario20005000.visibility = nuevoEstado
        binding.textViewSalario50008000.visibility = nuevoEstado
        binding.textViewSalarioMas8000.visibility = nuevoEstado
        binding.textViewHorario.visibility = nuevoEstado
        binding.textViewHorario4.visibility = nuevoEstado
        binding.textViewHorario5.visibility = nuevoEstado
        binding.textViewHorario6.visibility = nuevoEstado
        binding.textViewHorario7.visibility = nuevoEstado
        binding.textViewHorario8.visibility = nuevoEstado
        binding.textViewHorario9.visibility = nuevoEstado

    }
}
