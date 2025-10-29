package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityPantallaDeInicioBinding

class PantallaDeInicioActivity : AppCompatActivity() {
    val context: Context = this
    private lateinit var binding: ActivityPantallaDeInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityPantallaDeInicioBinding.inflate(layoutInflater)
        val view = binding.pantallaDeInicio
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pantalla_de_inicio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.bottonIniciarsesion.setOnClickListener {
            val intentCambioPantalla: Intent = Intent(this , IniciarSesionActivity::class.java)
            startActivity(intentCambioPantalla)
        }
        binding.bottonRegistrarse.setOnClickListener {
            val intentCambioPantalla: Intent = Intent(this , RegistrarActivity::class.java)
            startActivity(intentCambioPantalla)
        }

    }
}