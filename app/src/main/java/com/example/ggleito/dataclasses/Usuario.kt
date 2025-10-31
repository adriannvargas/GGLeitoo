package com.example.ggleito.dataclasses

import java.io.Serializable

data class Usuario(
    val nombres: String,
    val apellidos: String,
    val email: String,
    val ocupacion: String,
    val edad: Int,
    val departamento: String? = null
) : Serializable

