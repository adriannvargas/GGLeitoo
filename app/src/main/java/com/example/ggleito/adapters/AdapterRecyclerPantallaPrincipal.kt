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


class AdapterRecyclerPantallaPrincipal(private val mostrarClick: String = "PantallaPrincipal"): RecyclerView.Adapter<AdapterRecyclerPantallaPrincipal.PantallaPrincipalCardViewHolder>() {

    private val dataCards = mutableListOf<Trabajos>()
    private var context: Context? = null

    companion object{
        val TRABAJO_JSON = "id_trabajos_json"
        val TRABAJO_JSON2 = "id_trabajo_json2"
        val TRABAJO_JSON3 = "id_trabajo_json3"
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
        if(mostrarClick == "PantallaPrincipal"){

            holder.itemView.setOnClickListener {

                val trabajoEspecifico = dataCards[position]
                val trabajoJson = Json.encodeToString(trabajoEspecifico)

                val intent: Intent = Intent(context, DetallesTrabajoActivity::class.java).apply {
                putExtra(TRABAJO_JSON, trabajoJson)
                    putExtra("ORIGEN", DetallesTrabajoActivity.ORIGEN_PRINCIPAL)
            }

            context?.startActivity(intent)
            }
        }else if(mostrarClick == "TrabajosPostulados"){

            holder.itemView.setOnClickListener {

                val trabajoEspecifico2 = dataCards[position]
                val trabajoJson2 = Json.encodeToString(trabajoEspecifico2)

                val cambioDePantallaEnPostulados: Intent = Intent(context, DetallesTrabajoActivity::class.java).apply {
                    putExtra(TRABAJO_JSON2,trabajoJson2)
                    putExtra("ORIGEN", DetallesTrabajoActivity.ORIGEN_POSTULADOS)

                }

                context?.startActivity(cambioDePantallaEnPostulados)

            }
        }else if(mostrarClick == "TrabajosBusqueda"){

            holder.itemView.setOnClickListener {

                val trabajoEspecifico3 = dataCards[position]
                val trabajoJson3 = Json.encodeToString((trabajoEspecifico3))

                val cambioDePantallaEnBusqueda: Intent = Intent(context, DetallesTrabajoActivity::class.java).apply {
                    putExtra(TRABAJO_JSON3, trabajoJson3)
                    putExtra("ORIGEN", DetallesTrabajoActivity.ORIGEN_BUSQUEDA)

                }
                context?.startActivity(cambioDePantallaEnBusqueda)

            }

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