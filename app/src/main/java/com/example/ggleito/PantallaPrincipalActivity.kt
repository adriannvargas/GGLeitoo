package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal
import com.example.ggleito.databinding.ActivityPantallaPrincipalBinding
import com.example.ggleito.dataclasses.Trabajos
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class PantallaPrincipalActivity : AppCompatActivity() {

    val context: Context = this

    private lateinit var binding: ActivityPantallaPrincipalBinding

    val adpater by lazy { AdapterRecyclerPantallaPrincipal(mostrarClick = "PantallaPrincipal") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val listaTrabajos = ListaGlobal.listaTrabajosTotal
        val trabajosRecomendados = listaTrabajos.shuffled().take(30)

        adpater.addDataCards(trabajosRecomendados)

        binding.recyclerPantallaRecomendados.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerPantallaRecomendados.adapter = adpater


        binding.perfilPantallaPrincipal.setOnClickListener {

            val intentCambioDePantallaPerfilActivity =
                Intent(context, PantallaPerfilActivity::class.java)
            startActivity(intentCambioDePantallaPerfilActivity)
        }

        binding.iconoTrabajosPostulados.setOnClickListener {
            val intentIraPostulados = Intent(context, TrabajosPostuladosActivity::class.java)
            startActivity(intentIraPostulados)
        }


        binding.iconoBuscar.setOnClickListener {
            val intentIraBusqueda: Intent = Intent(context, BusquedaActivity::class.java)
            startActivity(intentIraBusqueda)
        }
    }
}