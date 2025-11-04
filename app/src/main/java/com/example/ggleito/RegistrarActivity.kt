package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityRegistrarBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.example.ggleito.dataclasses.Usuario
import com.google.gson.Gson

class RegistrarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var auth: FirebaseAuth
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sys.left, sys.top, sys.right, sys.bottom)
            insets
        }
        auth = Firebase.auth
        binding.botonCrearCuenta.setOnClickListener {
            val correo = binding.editTextEmail.text.toString()
            val pass = binding.editTextContrasena.text.toString()

            if (correo.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(correo, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val nombres = binding.editTextNombres.text.toString()
                    val apellidos = binding.editTextApellidos.text.toString()
                    val email = binding.editTextEmail.text.toString()
                    val ocupacion = binding.editTextOcupacion.text.toString()
                    val edad = binding.editTextEdad.text.toString().toIntOrNull() ?: 0

                    val usuario = Usuario(nombres, apellidos, email, ocupacion, edad)

                    val sharedPref = getSharedPreferences("UsuarioData", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    val gson = Gson()
                    val json = gson.toJson(usuario)
                    editor.putString("usuario_json", json)
                    editor.apply()

                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                    val intentLogin = Intent(context, SeleccionaCiudadActivity::class.java)
                    startActivity(intentLogin)
                } else {
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        }
    }
}
