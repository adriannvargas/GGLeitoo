package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal
import com.example.ggleito.databinding.ActivityBusquedaBinding
import com.example.ggleito.dataclasses.Trabajos
import kotlinx.serialization.json.Json

class BusquedaActivity : AppCompatActivity() {

    private val context: Context = this

    private lateinit var binding: ActivityBusquedaBinding

    private val adapter by lazy { AdapterRecyclerPantallaPrincipal("TrabajosBusqueda") }

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

        binding.recyclerPantallaBusqueda.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerPantallaBusqueda.adapter = adapter

        val trabajosRecibidosJson = intent.getStringExtra("listaTrabajos")!! //Para indicar que esto no sera nulo

        val trabajosRecibidos = Json.decodeFromString<List<Trabajos>>(trabajosRecibidosJson)

        val trabajosaMostrarse = mutableListOf<Trabajos>()

        fun mostrarTrabjosBuscados(palabraClave: String){

            trabajosaMostrarse.clear()

            for(i in 0 until trabajosRecibidos.size){
                if(trabajosRecibidos[i].areaTrabajo == palabraClave){
                    trabajosaMostrarse.add(trabajosRecibidos[i])
                }

            }

            adapter.addDataCards(trabajosaMostrarse)
        }

        fun mostrarTrabajosFiltrados(salarioSeleccionadoMin: Int,salarioSeleccionadoMax: Int, horarioSeleccionado: Int){

            for(i in 0 until trabajosRecibidos.size){
                if (trabajosRecibidos[i].salario >= salarioSeleccionadoMin && trabajosRecibidos[i].salario <=  salarioSeleccionadoMax && (trabajosRecibidos[i].horarioFin - trabajosRecibidos[i].horarioInicio) == horarioSeleccionado){


                }

            }

        }

        binding.bottonBuscar.setOnClickListener {

            val palabraEscrita = binding.editTextBuscadorTrabajos.text.toString()
            mostrarTrabjosBuscados(palabraEscrita)

        }

        binding.iconoHome.setOnClickListener {
            val volverAlInicio: Intent = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(volverAlInicio)
        }


        binding.iconoTrabajosPostulados.setOnClickListener {

            val intentCambioDePantallaPostulados =
                Intent(context, TrabajosPostuladosActivity::class.java)
            startActivity(intentCambioDePantallaPostulados)
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
