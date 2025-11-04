package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.TextView
import android.widget.Toast
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

    private var salarioMinSeleccionado = 0

    private var salarioMaxSeleccionado = 0

    private var horarioSeleccionado = 0

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
        binding.iconoCancelar.setOnClickListener {
            binding.editTextBuscadorTrabajos.text.clear()
        }

        binding.recyclerPantallaBusqueda.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerPantallaBusqueda.adapter = adapter

        val trabajosRecibidos = ListaGlobal.listaTrabajosTotal

        val trabajosaMostrarse = mutableListOf<Trabajos>()
        fun mostrarTrabjosBuscados(palabraClave: String) {
            trabajosaMostrarse.clear()
            val claveEnMinusculas = palabraClave.trim().lowercase()
            if (claveEnMinusculas.isNotEmpty()) {
                for (i in 0 until trabajosRecibidos.size) {
                    if (trabajosRecibidos[i].areaTrabajo.lowercase().contains(claveEnMinusculas)) {
                        trabajosaMostrarse.add(trabajosRecibidos[i])
                    }
                }

            }

            adapter.addDataCards(trabajosaMostrarse)
        }

        fun mostrarTrabajosFiltrados(salarioSeleccionadoMin: Int, salarioSeleccionadoMax: Int, horarioSeleccionado: Int) {

            if(salarioSeleccionadoMin == 0 || salarioSeleccionadoMax == 0){

                Toast.makeText(this, "Selecciona salario y horario", Toast.LENGTH_SHORT).show()

            }else{
                trabajosaMostrarse.clear()

                for (i in trabajosRecibidos.indices) {
                    val trabajo = trabajosRecibidos[i]
                    val duracionHorario = trabajo.horarioFin - trabajo.horarioInicio
                    val cumpleSalario = if (salarioMaxSeleccionado == Int.MAX_VALUE) {
                        trabajo.salario >= salarioSeleccionadoMin
                    } else {
                        trabajo.salario >= salarioSeleccionadoMin && trabajo.salario <= salarioSeleccionadoMax
                    }

                    if (cumpleSalario && duracionHorario == horarioSeleccionado) {
                        trabajosaMostrarse.add(trabajo)
                    }
                }

                adapter.addDataCards(trabajosaMostrarse)
            }

        }

        fun actualizarBotonesSalario() {

            binding.textViewSalario20005000.setBackgroundResource(R.drawable.roundedlayoutblanco)
            binding.textViewSalario50008000.setBackgroundResource(R.drawable.roundedlayoutblanco)
            binding.textViewSalarioMas8000.setBackgroundResource(R.drawable.roundedlayoutblanco)

            when (salarioMinSeleccionado) {
                2000 -> binding.textViewSalario20005000.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
                5000 -> binding.textViewSalario50008000.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
                8000 -> binding.textViewSalarioMas8000.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
            }
        }

        fun actualizarBotonesHorario() {

            val botonesHorario = listOf(binding.textViewHorario4,binding.textViewHorario5, binding.textViewHorario6,
                binding.textViewHorario7, binding.textViewHorario8)
            botonesHorario.forEach { it.setBackgroundResource(R.drawable.roundedlayoutblanco) }

            when (horarioSeleccionado) {
                4 -> binding.textViewHorario4.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
                5 -> binding.textViewHorario5.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
                6 -> binding.textViewHorario6.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
                7 -> binding.textViewHorario7.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
                8 -> binding.textViewHorario8.setBackgroundResource(R.drawable.roundedlayoutbeigeconbordesnegros)
            }
        }

        binding.textViewSalario20005000.setOnClickListener {
            salarioMinSeleccionado = 2000
            salarioMaxSeleccionado = 5000
            actualizarBotonesSalario()
        }
        binding.textViewSalario50008000.setOnClickListener {
            salarioMinSeleccionado = 5000
            salarioMaxSeleccionado = 8000
            actualizarBotonesSalario()
        }
        binding.textViewSalarioMas8000.setOnClickListener {
            salarioMinSeleccionado = 8000
            salarioMaxSeleccionado = 20000
            actualizarBotonesSalario()
        }

        binding.textViewHorario4.setOnClickListener {
            horarioSeleccionado = 4
            actualizarBotonesHorario()
        }

        binding.textViewHorario5.setOnClickListener {
            horarioSeleccionado = 5
            actualizarBotonesHorario()
        }

        binding.textViewHorario6.setOnClickListener {
            horarioSeleccionado = 6
            actualizarBotonesHorario()
        }

        binding.textViewHorario7.setOnClickListener {
            horarioSeleccionado = 7
            actualizarBotonesHorario()
        }


        binding.textViewHorario8.setOnClickListener {
            horarioSeleccionado = 8
            actualizarBotonesHorario()
        }

        binding.bottonBuscar.setOnClickListener {

            binding.textViewSalario.visibility = TextView.GONE
            binding.textViewSalario20005000.visibility = TextView.GONE
            binding.textViewSalario50008000.visibility = TextView.GONE
            binding.textViewSalarioMas8000.visibility = TextView.GONE
            binding.textViewHorario.visibility = TextView.GONE
            binding.textViewHorario4.visibility = TextView.GONE
            binding.textViewHorario5.visibility = TextView.GONE
            binding.textViewHorario6.visibility = TextView.GONE
            binding.textViewHorario7.visibility = TextView.GONE
            binding.textViewHorario8.visibility = TextView.GONE

            if(binding.editTextBuscadorTrabajos.text.toString() == ""){
                mostrarTrabajosFiltrados(salarioMinSeleccionado,salarioMaxSeleccionado,horarioSeleccionado)

            }else{
                val palabraEscrita = binding.editTextBuscadorTrabajos.text.toString()
                mostrarTrabjosBuscados(palabraEscrita)
            }



        }

        binding.iconoHome.setOnClickListener {
            val volverAlInicio: Intent = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(volverAlInicio)
        }


        binding.iconoTrabajosPostulados.setOnClickListener {

            val intentCambioDePantallaPostulados = Intent(context, TrabajosPostuladosActivity::class.java)
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

    }

}
