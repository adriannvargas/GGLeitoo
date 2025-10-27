package com.example.ggleito

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal
import com.example.ggleito.databinding.ActivityPantallaPrincipalBinding
import com.example.ggleito.dataclasses.Trabajos


class PantallaPrincipalActivity : AppCompatActivity() {

    val context : Context = this

    private lateinit var binding: ActivityPantallaPrincipalBinding

    val adpater by lazy { AdapterRecyclerPantallaPrincipal() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val trabajosRecomendados = mutableListOf<Trabajos>()

        trabajosRecomendados.add(Trabajos("Soboce", 3000, "La Paz", 8,3, "Asistente de Logística y Despacho: Integramos a un Asistente de Logística. Apoyarás la planificación y el control de inventario de materiales de construcción, coordinando rutas de despacho para asegurar la entrega eficiente de nuestros productos.", R.drawable.soboce))
        trabajosRecomendados.add(Trabajos("Banco Mercantil SC", 4000, "La Paz", 9,5, "Ejecutivo de Servicios y Plataforma: Oportunidad para Ejecutivos de Servicios. Tu rol será crucial en la atención al cliente en plataforma, la apertura de cuentas y la promoción de productos bancarios, garantizando un servicio de excelencia.", R.drawable.bmsc))
        trabajosRecomendados.add(Trabajos("Hipermaxi", 2750, "Cochabamba", 7,3, "Personal Operativo/Cajero: Personal Operativo para diversas áreas de tienda. Tu enfoque será en el servicio al cliente, la reposición de mercadería y el manejo de caja, siendo la cara de Hipermaxi ante nuestros clientes.", R.drawable.hipermaxi))
        trabajosRecomendados.add(Trabajos("Tigo Bolivia", 4500, "Santa Cruz", 10,6, "Asesor Comercial/Ventas: Únete a Tigo como Asesor Comercial. Serás responsable de la venta y promoción de nuestros servicios (telefonía, internet, TV) en puntos de venta o call center, alcanzando metas mensuales.", R.drawable.tigo))
        trabajosRecomendados.add(Trabajos("Toyota Bolivia", 4500, "Santa Cruz", 10,6, "Asesor de Ventas de Vehículos: Contratamos Asesores de Venta apasionados por la industria automotriz. Promociona y vende nuestra flota de vehículos, gestionando la cartera de clientes y asegurando una experiencia de compra premium.", R.drawable.toyota))
        trabajosRecomendados.add(Trabajos("Burger King", 4500, "Santa Cruz", 10,6, "Supervisor de Turno: Buscamos Supervisores de Turno con liderazgo. Gestionarás las operaciones diarias del restaurante, capacitarás al personal y asegurarás el cumplimiento de estándares de calidad y servicio al cliente.", R.drawable.burguerking))

        adpater.addDataCards(trabajosRecomendados)

        binding.recyclerPantallaRecomendados.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerPantallaRecomendados.adapter = adpater


    }
}