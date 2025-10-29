package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityDetallesTrabajoBinding
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal.Companion.TRABAJO_JSON
import com.example.ggleito.dataclasses.Trabajos
import kotlinx.serialization.json.Json

class DetallesTrabajoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesTrabajoBinding

    var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetallesTrabajoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val trabajoJson: String? = intent.getStringExtra(TRABAJO_JSON)


        //Estamos convirtiendo el Json de nuevo a objeto
        val trabajo = trabajoJson?.let {
            Json.decodeFromString<Trabajos>(it)
        }

        fun mostrarDetallesTrabajo(trabajo: Trabajos){

            binding.textViewPuestoTrabajo.text = trabajo.puestoTrabajo
            binding.textViewNombreTrabajo.text = trabajo.nombreTrabajo
            binding.textViewSalario.text = "Salario: \n${trabajo.salario.toString()} Bs"
            binding.textViewDescripcion.text = "Descripcion: \n${trabajo.descripcion}"
            binding.textViewHorario.text = "Horario: \n${trabajo.horarioInicio}:00 - ${trabajo.horarioFin}:00"
            binding.textViewUbicacion.text = "Ubicacion: \n${trabajo.ciudad}"
            binding.imageViewTrabajo.setImageResource(trabajo.imagen)

        }

        if(trabajo != null){
            mostrarDetallesTrabajo(trabajo)
        }

        binding.botonPostular.setOnClickListener {
            android.widget.Toast.makeText(this, "Has postulado a: ${trabajo?.nombreTrabajo}", android.widget.Toast.LENGTH_SHORT).show()
        }

        binding.imageViewCasa.setOnClickListener {

            val intentCambioPantalla: Intent = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentCambioPantalla)

        }



    }
}