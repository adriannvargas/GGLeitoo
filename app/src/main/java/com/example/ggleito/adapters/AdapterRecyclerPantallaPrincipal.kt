package com.example.ggleito.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ggleito.databinding.AdapterPantallaPrincipalBinding
import com.example.ggleito.dataclasses.Trabajos



class AdapterRecyclerPantallaPrincipal: RecyclerView.Adapter<AdapterRecyclerPantallaPrincipal.PantallaPrincipalCardViewHolder>() {

    private val dataCards = mutableListOf<Trabajos>()
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantallaPrincipalCardViewHolder {

        context = parent.context
        return PantallaPrincipalCardViewHolder(
            AdapterPantallaPrincipalBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PantallaPrincipalCardViewHolder, position: Int) {
        holder.binding(dataCards[position])
    }

    override fun getItemCount(): Int = dataCards.size

    inner class PantallaPrincipalCardViewHolder(private val binding: AdapterPantallaPrincipalBinding): RecyclerView.ViewHolder(binding.root){

        fun binding(data: Trabajos){

            binding.textViewAdapterNombre.text = data.nombreTrabajo
            binding.textViewAdapterSalario.text = "Salario: ${data.salario}"
            binding.imagenTrabajo.setImageResource(data.imagen)

        }

    }
    fun addDataCards(list: List<Trabajos>){

        dataCards.clear()
        dataCards.addAll(list)
    }


}