package com.example.ggleito

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityDepartamentoSeleccionadoBinding

class DepartamentoSeleccionadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDepartamentoSeleccionadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDepartamentoSeleccionadoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pantalla_departamento_seleccionado)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageResId = intent.getIntExtra("imagen_departamento", 0)
        if (imageResId != 0) {
            binding.imagenDepartamento.setImageResource(imageResId)
        }
        binding.botonSiguiente.setOnClickListener {
            val nombreDepartamento = intent.getStringExtra("nombre_departamento")

            if (nombreDepartamento != null) {
                val sharedPref = getSharedPreferences("UsuarioData", MODE_PRIVATE)
                val gson = com.google.gson.Gson()
                val json = sharedPref.getString("usuario_json", null)

                if (json != null) {
                    val usuario = gson.fromJson(json, com.example.ggleito.dataclasses.Usuario::class.java)
                    val usuarioActualizado = usuario.copy(departamento = nombreDepartamento)
                    val jsonActualizado = gson.toJson(usuarioActualizado)
                    sharedPref.edit().putString("usuario_json", jsonActualizado).apply()
                }
            }

            val intent = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intent)
        }
    }
}
