package com.example.ggleito.dataclasses

import kotlinx.serialization.Serializable


@Serializable
data class Trabajos(

    val nombreTrabajo: String,
    val puestoTrabajo: String,
    val salario: Int,
    val ciudad: String,
    val horarioInicio: Int,
    val horarioFin: Int,
    val descripcion: String,
    val imagen: Int

)
