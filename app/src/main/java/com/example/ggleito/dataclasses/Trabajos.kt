package com.example.ggleito.dataclasses

import android.media.Image
import java.util.Date

data class Trabajos(

    val nombreTrabajo: String,
    val salario: Int,
    val ciudad: String,
    val horarioInicio: Int,
    val horarioFin: Int,
    val descripcion: String,
    val imagen: Int

)
