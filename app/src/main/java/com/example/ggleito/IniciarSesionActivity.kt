package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.contracts.contract

class IniciarSesionActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciar_sesion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_iniciar_sesion)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        val butonLogin = findViewById<Button>(R.id.boton_continuar)
        val editCorreo = findViewById<EditText>(R.id.edit_text_correo_electronico)
        val editPass = findViewById<EditText>(R.id.edit_text_contrasena)
        butonLogin.setOnClickListener {
            val correo = editCorreo.text.toString()
            val pass = editPass.text.toString()
            if (correo != "" && pass != ""){
                loginValidation(correo, pass)
            } else {
                Toast.makeText(
                    baseContext,
                    "Debe ingresar Correo y contraseña",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
        butonLogin.setOnClickListener {
            val correo = editCorreo.text.toString()
            val pass = editPass.text.toString()
            if (pass.length < 8 || correo == ""){
                Toast.makeText(
                    baseContext,
                    "Debe ingresar una contraseña de 8 o mas digitos y debe ingresar un correo",
                    Toast.LENGTH_SHORT,
                ).show()
            } else {
                crearUsuario(correo, pass)
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intentPantallaPrincipal = Intent(context, PantallaDeInicioActivity::class.java)
            startActivity(intentPantallaPrincipal)
        }
    }
    fun crearUsuario(
        correo:String,
        pass: String
    ){
        auth.createUserWithEmailAndPassword(correo, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intentLogin = Intent(context, PantallaDeInicioActivity::class.java)
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
    fun loginValidation(
        correo:String,
        pass: String
    ){
        auth.signInWithEmailAndPassword(correo,pass).addOnCompleteListener { task ->
            if(task.isSuccessful){
                //el usuario se logeo correctamente
            }else{
                //el usuraio no se pudo logear
                Toast.makeText(
                    baseContext,
                    "No pudimos loguear ese usuario y contrasena.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}