package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityDetallesTrabajoBinding
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal.Companion.TRABAJO_JSON
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal.Companion.TRABAJO_JSON2
import com.example.ggleito.dataclasses.Trabajos
import com.example.ggleito.managers.TrabajosPostuladosManager
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

        val trabajoJsonPostulados: String? = intent.getStringExtra(TRABAJO_JSON2)


        //Estamos convirtiendo el Json de nuevo a objeto
        val trabajo = trabajoJson?.let {
            Json.decodeFromString<Trabajos>(it)
        }

        val trabajo2 = trabajoJsonPostulados?.let {
            Json.decodeFromString<Trabajos>(it)
        }



        fun mostrarDetallesTrabajo(trabajo: Trabajos){

            binding.textViewPuestoTrabajo.text = trabajo.puestoTrabajo
            binding.textViewNombreTrabajo.text = trabajo.nombreTrabajo
            binding.textViewSalario.text = "Salario: \n${trabajo.salario.toString()} Bs"
            binding.textViewDescripcion.text = "Descripcion: \n${trabajo.descripcion}"
            binding.textViewHorario.text = "Horario: \n${trabajo.horarioInicio}:00 - ${trabajo.horarioFin}:00"
            binding.textViewUbicacion.text = "Ubicacion: \n${trabajo.ciudad}"
            binding.imageViewTrabajo.setImageResource(trabajo.imagen )


        }

        if(trabajo != null ){

            mostrarDetallesTrabajo(trabajo)

        }

        if (trabajo2 != null){
            mostrarDetallesTrabajo(trabajo2)

            binding.botonEliminarPostulacion.visibility = Button.VISIBLE
            binding.botonPostular.visibility = Button.GONE
        }

        binding.botonPostular.setOnClickListener {

            //let hace que nos aseguremos que el trabajo no sea null
            trabajo?.let { trabajoSeleccionado ->

                TrabajosPostuladosManager.agregarTrabajos(this, trabajoSeleccionado)
                android.widget.Toast.makeText(this, "Has postulado a: ${trabajo?.nombreTrabajo}", android.widget.Toast.LENGTH_SHORT).show()

            }?: run {
                android.widget.Toast.makeText(this, "Error, no se pudo postular", android.widget.Toast.LENGTH_SHORT).show()
            }

            binding.imageViewConfirmacionPostulacion.visibility = ImageView.VISIBLE
            binding.botonConfirmacionPostulacion.visibility = Button.VISIBLE
            binding.constraintPadre2.visibility = View.INVISIBLE
            binding.botonPostular.visibility = Button.INVISIBLE

        }

        binding.botonEliminarPostulacion.setOnClickListener {

            trabajo2?.let { trabajoaEliminar->

                TrabajosPostuladosManager.eliminarTrabajo(this,trabajoaEliminar)
                android.widget.Toast.makeText(this, "Has eliminado tu postulacion a: ${trabajo2?.nombreTrabajo}", android.widget.Toast.LENGTH_SHORT).show()
                val vueltaPantallaPostulados : Intent = Intent(context, TrabajosPostuladosActivity::class.java)
                startActivity(vueltaPantallaPostulados)

            }?: run {
                android.widget.Toast.makeText(this, "Error, no pudiste cancelar tu postulacion", android.widget.Toast.LENGTH_SHORT).show()
            }

        }

        binding.botonConfirmacionPostulacion.setOnClickListener {

            val intentVolverAlInicio = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentVolverAlInicio)

        }


        binding.imageViewCasa.setOnClickListener {

            val intentCambioPantalla: Intent = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentCambioPantalla)

        }
        binding.imageViewFlechas.setOnClickListener {
            val intentCambioPantalla: Intent = Intent(context, TrabajosPostuladosActivity::class.java)
            startActivity(intentCambioPantalla)
        }



    }
}