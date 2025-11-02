package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityPantallaPerfilBinding
import com.google.gson.Gson
import com.example.ggleito.dataclasses.Usuario
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class PantallaPerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaPerfilBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context: Context = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        binding.bottonCerrarSesion.setOnClickListener {
            auth.signOut()
            val intenVolverInicioSesion = Intent(context, PantallaDeInicioActivity::class.java)
            startActivity(intenVolverInicioSesion)
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
        binding.iconoBuscar.setOnClickListener {
            val intentBusqueda = Intent(context, BusquedaActivity::class.java)
            startActivity(intentBusqueda)
        }

            val sharedPref = getSharedPreferences("UsuarioData", Context.MODE_PRIVATE)
            val json = sharedPref.getString("usuario_json", null)

            if (json != null) {
                val gson = Gson()
                val usuario = gson.fromJson(json, Usuario::class.java)
                binding.textoNombre.text = "Nombre: ${usuario.nombres} ${usuario.apellidos}"
                binding.textoOcupacion.text = "Ocupación: ${usuario.ocupacion}"
                binding.textoEmail.text = "Email: ${usuario.email}"
                binding.textoEdad.text = "Edad: ${usuario.edad}"
                binding.textoCiudad.text = "Ciudad: ${usuario.departamento}"
            }
        }
    }



