package com.example.ggleito.managers

import android.content.Context
import android.content.SharedPreferences
import com.example.ggleito.dataclasses.Trabajos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TrabajosPostuladosManager {
    private const val PREFS_NAME = "trabajos_postulados"
    private const val KEY_TRABAJOS = "lista_trabajos"
    private val gson = Gson()

    fun agregarTrabajos(context: Context, trabajo: Trabajos) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val trabajosExistentes = obtenerTrabajos(context).toMutableList()

        if (!trabajosExistentes.any { it.puestoTrabajo == trabajo.puestoTrabajo }) {
            trabajosExistentes.add(trabajo)
            val jsonList = gson.toJson(trabajosExistentes)
            prefs.edit().putString(KEY_TRABAJOS, jsonList).apply()
        }
    }

    fun obtenerTrabajos(context: Context): List<Trabajos> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_TRABAJOS, null)
        return if (json != null) {
            try {
                val type = object : TypeToken<List<Trabajos>>() {}.type
                gson.fromJson(json, type) ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        } else {
            emptyList()
        }
    }

    fun eliminarTrabajo(context: Context, trabajo: Trabajos) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val trabajosExistentes = obtenerTrabajos(context).toMutableList()

        trabajosExistentes.removeAll { it.puestoTrabajo == trabajo.puestoTrabajo }
        val jsonList = gson.toJson(trabajosExistentes)
        prefs.edit().putString(KEY_TRABAJOS, jsonList).apply()
    }
}