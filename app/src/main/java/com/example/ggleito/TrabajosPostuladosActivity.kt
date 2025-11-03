package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal
import com.example.ggleito.databinding.ActivityDetallesTrabajoBinding
import com.example.ggleito.databinding.ActivityTrabajosPostuladosBinding
import com.example.ggleito.managers.TrabajosPostuladosManager

class TrabajosPostuladosActivity : AppCompatActivity() {

    private val context: Context = this

    private lateinit var binding: ActivityTrabajosPostuladosBinding

    private val adapter by lazy { AdapterRecyclerPantallaPrincipal("TrabajosPostulados") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTrabajosPostuladosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun setUpRecyclerView(){

            binding.recyclerPantallaPostulados.layoutManager = GridLayoutManager(this,1)
            binding.recyclerPantallaPostulados.adapter = adapter
        }

        fun mostrarTrabajosPostulados(){

            val trabajosPostulados = TrabajosPostuladosManager.obtenerTrabajos(this)
            adapter.addDataCards(trabajosPostulados)


            if (trabajosPostulados.isEmpty()) {
                android.widget.Toast.makeText(
                    this,
                    "Aún no te has postulado a ningún trabajo",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.iconoHome.setOnClickListener {
            val intentVolverPantallaPrincipal = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentVolverPantallaPrincipal)
        }

        binding.imageViewPerfil.setOnClickListener {

            val intentCambioDePantallaPerfilActivity = Intent(context, PantallaPerfilActivity::class.java)
            startActivity(intentCambioDePantallaPerfilActivity)
        }
        binding.iconoBuscar.setOnClickListener {
            val intentBusqueda = Intent(context, BusquedaActivity::class.java)
            startActivity(intentBusqueda)
        }


        fun actualizarLista(){
            mostrarTrabajosPostulados()
        }

        setUpRecyclerView()
        mostrarTrabajosPostulados()

    }
}