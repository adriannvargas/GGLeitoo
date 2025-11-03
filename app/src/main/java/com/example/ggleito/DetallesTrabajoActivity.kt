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
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal.Companion.TRABAJO_JSON3
import com.example.ggleito.dataclasses.Trabajos
import com.example.ggleito.managers.TrabajosPostuladosManager
import kotlinx.serialization.json.Json

class DetallesTrabajoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesTrabajoBinding

    var context: Context = this

    companion object{

        const val ORIGEN_PRINCIPAL = "origen_principal"
        const val ORIGEN_POSTULADOS = "origen_postulados"
        const val ORIGEN_BUSQUEDA = "origen_busqueda"

    }

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

        val origen = intent.getStringExtra("ORIGEN")?: ORIGEN_PRINCIPAL

        fun mostrarDetallesTrabajo(trabajo: Trabajos){

            binding.textViewPuestoTrabajo.text = trabajo.puestoTrabajo
            binding.textViewNombreTrabajo.text = trabajo.nombreTrabajo
            binding.textViewSalario.text = "Salario: \n${trabajo.salario.toString()} Bs"
            binding.textViewDescripcion.text = "Descripcion: \n${trabajo.descripcion}"
            binding.textViewHorario.text = "Horario: \n${trabajo.horarioInicio}:00 - ${trabajo.horarioFin}:00"
            binding.textViewUbicacion.text = "Ubicacion: \n${trabajo.ciudad}"
            binding.imageViewTrabajo.setImageResource(trabajo.imagen )

        }

        fun configuracionBotonPostular(trabajo: Trabajos){

            binding.botonPostular.setOnClickListener {

                TrabajosPostuladosManager.agregarTrabajos(this, trabajo)
                android.widget.Toast.makeText(this, "Has postulado a: ${trabajo.nombreTrabajo}", android.widget.Toast.LENGTH_SHORT).show()

                binding.botonPostular.visibility = Button.GONE
                binding.constraintPadre2.visibility = View.GONE

                binding.botonConfirmacionPostulacion.visibility = Button.VISIBLE
                binding.imageViewConfirmacionPostulacion.visibility = ImageView.VISIBLE

            }

        }

        fun configuracionBotonEliminar(trabajo: Trabajos){

            binding.botonEliminarPostulacion.visibility = View.VISIBLE
            binding.botonPostular.visibility = View.GONE

            binding.botonEliminarPostulacion.setOnClickListener {

                    TrabajosPostuladosManager.eliminarTrabajo(this,trabajo)
                    android.widget.Toast.makeText(this, "Has eliminado tu postulacion a: ${trabajo.nombreTrabajo}", android.widget.Toast.LENGTH_SHORT).show()
                    val vueltaPantallaPostulados : Intent = Intent(context, TrabajosPostuladosActivity::class.java)
                    startActivity(vueltaPantallaPostulados)
            }

        }

        when(origen){
            ORIGEN_PRINCIPAL->{
                val trabajoJsonPrincipal: String = intent.getStringExtra(TRABAJO_JSON)!!
                val trabajoPrincipal = Json.decodeFromString<Trabajos>(trabajoJsonPrincipal)

                mostrarDetallesTrabajo(trabajoPrincipal)
                configuracionBotonPostular(trabajoPrincipal)
            }
            ORIGEN_POSTULADOS->{
                val trabajoJsonPostulados = intent.getStringExtra(TRABAJO_JSON2)!!
                val trabajoPostulados = Json.decodeFromString<Trabajos>(trabajoJsonPostulados)

                mostrarDetallesTrabajo(trabajoPostulados)
                configuracionBotonEliminar(trabajoPostulados)
            }
            ORIGEN_BUSQUEDA->{
                val trabajoJsonBusqueda = intent.getStringExtra(TRABAJO_JSON3)!!
                val trabajoBusqueda = Json.decodeFromString<Trabajos>(trabajoJsonBusqueda)

                mostrarDetallesTrabajo(trabajoBusqueda)
                configuracionBotonPostular(trabajoBusqueda)
            }

        }


        binding.botonConfirmacionPostulacion.setOnClickListener {

            val intentVolverAlInicio = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentVolverAlInicio)
        }


        binding.imageViewPerfil.setOnClickListener {

            val intentCambioDePantallaPerfilActivity = Intent(context, PantallaPerfilActivity::class.java)
            startActivity(intentCambioDePantallaPerfilActivity)
        }
        binding.iconoBuscar.setOnClickListener {
            val intentIrBusqueda = Intent(context, BusquedaActivity::class.java)
            startActivity(intentIrBusqueda)
        }

        binding.iconoTrabajosPostulados.setOnClickListener {
            val intentTrabajosPostulados = Intent(context, TrabajosPostuladosActivity::class.java)
            startActivity(intentTrabajosPostulados)
        }
        binding.iconoHome.setOnClickListener {
            val intentVolverPantallaPrincipal = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentVolverPantallaPrincipal)
        }


    }
}