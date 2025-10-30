package com.example.ggleito

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ggleito.databinding.ActivityIniciarSesionBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class IniciarSesionActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityIniciarSesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sys.left, sys.top, sys.right, sys.bottom)
            insets
        }
        auth = Firebase.auth
        binding.botonContinuar.setOnClickListener {
            val correo = binding.editTextCorreoElectronico.text.toString()
            val pass = binding.editTextContrasena.text.toString()
            auth.signInWithEmailAndPassword(correo, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, PantallaPrincipalActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this,
                            "No pudimos loguear ese usuario y contraseña.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            val intentPantallaPrincipal = Intent(this, PantallaPrincipalActivity::class.java)
//            startActivity(intentPantallaPrincipal)
//            finish()
//        }
    }
}


//        butonLogin.setOnClickListener {
//            val correo = editCorreo.text.toString()
//            val pass = editPass.text.toString()
//            if (correo != "" && pass != ""){
//                loginValidation(correo, pass)
//            } else {
//                Toast.makeText(
//                    baseContext,
//                    "Debe ingresar Correo y contraseña",
//                    Toast.LENGTH_SHORT,
//                ).show()
//            }
//        }
//        butonLogin.setOnClickListener {
//            val correo = editCorreo.text.toString()
//            val pass = editPass.text.toString()
//            if (pass.length < 8 || correo == ""){
//                Toast.makeText(
//                    baseContext,
//                    "Debe ingresar una contraseña de 8 o mas digitos y debe ingresar un correo",
//                    Toast.LENGTH_SHORT,
//                ).show()
//            } else {
//                crearUsuario(correo, pass)
//            }
//        }
//    }


//    fun crearUsuario(
//        correo:String,
//        pass: String
//    ){
//        auth.createUserWithEmailAndPassword(correo, pass)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    val intentLogin = Intent(context, PantallaDeInicioActivity::class.java)
//                    startActivity(intentLogin)
//
//
//                } else {
//                    Toast.makeText(
//                        baseContext,
//                        "Authentication failed.",
//                        Toast.LENGTH_SHORT,
//                    ).show()
//                }
//            }
//    }
//    fun loginValidation(
//        correo:String,
//        pass: String
//    ){
//
//}
//    }