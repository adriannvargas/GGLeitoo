package com.example.ggleito.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ggleito.DetallesTrabajoActivity
import com.example.ggleito.databinding.AdapterPantallaPrincipalBinding
import com.example.ggleito.dataclasses.Trabajos
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class AdapterRecyclerPantallaPrincipal: RecyclerView.Adapter<AdapterRecyclerPantallaPrincipal.PantallaPrincipalCardViewHolder>() {

    private val dataCards = mutableListOf<Trabajos>()
    private var context: Context? = null

    companion object{
        val TRABAJO_JSON = "id_trabajos_json"
    }



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

        holder.itemView.setOnClickListener {

            val trabajoEspecifico = dataCards[position]
            val trabajoJson = Json.encodeToString(trabajoEspecifico)

            val intent: Intent = Intent(context, DetallesTrabajoActivity::class.java).apply {
                putExtra(TRABAJO_JSON, trabajoJson)
            }

            context?.startActivity(intent)

        }

    }

    override fun getItemCount(): Int = dataCards.size

    inner class PantallaPrincipalCardViewHolder(private val binding: AdapterPantallaPrincipalBinding): RecyclerView.ViewHolder(binding.root){

        fun binding(data: Trabajos){

            binding.textViewAdapterNombre.text = data.nombreTrabajo
            binding.textViewAdapterSalario.text = "Salario: ${data.salario}"
            binding.imagenAdapterTrabajo.setImageResource(data.imagen)



        }

    }
    fun addDataCards(list: List<Trabajos>){

        dataCards.clear()
        dataCards.addAll(list)
        notifyDataSetChanged()
    }


}