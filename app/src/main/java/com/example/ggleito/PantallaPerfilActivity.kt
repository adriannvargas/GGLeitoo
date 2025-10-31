package com.example.ggleito

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityPantallaPerfilBinding
import com.google.gson.Gson
import com.example.ggleito.dataclasses.Usuario



class PantallaPerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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


