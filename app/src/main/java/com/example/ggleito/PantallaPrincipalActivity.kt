package com.example.ggleito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ggleito.adapters.AdapterRecyclerPantallaPrincipal
import com.example.ggleito.databinding.ActivityPantallaPrincipalBinding
import com.example.ggleito.dataclasses.Trabajos
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class PantallaPrincipalActivity : AppCompatActivity() {

    val context: Context = this

    private lateinit var binding: ActivityPantallaPrincipalBinding

    val adpater by lazy { AdapterRecyclerPantallaPrincipal(mostrarClick = "PantallaPrincipal") }

    companion object {
        val listaTotalTrabajos = mutableListOf<Trabajos>(
            Trabajos("Soboce","Asistente de Logística y Despacho" ,"Marketing", 3000, "La Paz", 8,3, "Integramos a un Asistente de Logística. Apoyarás la planificación y el control de inventario de materiales de construcción, coordinando rutas de despacho para asegurar la entrega eficiente de nuestros productos.", R.drawable.soboce),

            Trabajos(
                "Banco Mercantil SC","Ejecutivo de Servicios y Plataforma","Logistica", 4000, "La Paz", 9,5, " Oportunidad para Ejecutivos de Servicios. Tu rol será crucial en la atención al cliente en plataforma, la apertura de cuentas y la promoción de productos bancarios, garantizando un servicio de excelencia.", R.drawable.bmsc),
            Trabajos(
                "Hipermaxi", "Personal Operativo/Cajero","Publicidad",2750, "Cochabamba", 7,3, "Personal Operativo/Cajero Personal Operativo para diversas áreas de tienda. Tu enfoque será en el servicio al cliente, la reposición de mercadería y el manejo de caja, siendo la cara de Hipermaxi ante nuestros clientes.", R.drawable.hipermaxi),
            Trabajos(
                "Tigo Bolivia","Asesor Comercial/Ventas", "Telefonia",4500, "Santa Cruz", 10,6, " Únete a Tigo como Asesor Comercial. Serás responsable de la venta y promoción de nuestros servicios (telefonía, internet, TV) en puntos de venta o call center, alcanzando metas mensuales.", R.drawable.tigo),
            Trabajos(
                "Toyota Bolivia", "Asesor de Ventas de Vehículos","Mecanica",4500, "Santa Cruz", 10,6, " Contratamos Asesores de Venta apasionados por la industria automotriz. Promociona y vende nuestra flota de vehículos, gestionando la cartera de clientes y asegurando una experiencia de compra premium.", R.drawable.toyota),
            Trabajos("Burger King", "Supervisor de Turno","Cocina",4500, "Santa Cruz", 10,6, " Buscamos Supervisores de Turno con liderazgo. Gestionarás las operaciones diarias del restaurante, capacitarás al personal y asegurarás el cumplimiento de estándares de calidad y servicio al cliente.", R.drawable.burguerking),

            Trabajos("Banco BISA", "Cajero Bancario", "Atención al Cliente", 4200, "Santa Cruz", 9, 17, "Forma parte de nuestro equipo realizando operaciones de caja, depósitos y retiros, garantizando precisión y atención cordial a los clientes.", R.drawable.bancobisa),

            Trabajos("CRE R.L.", "Asistente Administrativo", "Atención al Cliente", 3800, "Cochabamba", 8, 15, "Apoyarás la gestión de documentos, control de archivo y atención a socios, asegurando el cumplimiento de procesos administrativos internos.", R.drawable.crerl),
            Trabajos("VIVA Bolivia", "Promotor de Ventas", "Atención al Cliente", 3000, "Sucre", 12, 18, "Serás responsable de ofrecer planes y servicios móviles en puntos de venta y ferias, orientando a los clientes para optimizar su experiencia.", R.drawable.viva),
            Trabajos("Gobierno Autónomo Municipal de La Paz", "Secretaria Ejecutiva", "Atención al Cliente", 3200, "Oruro", 12, 17, "Gestionarás la agenda institucional, elaboración de documentos y coordinación de reuniones internas.", R.drawable.gobiernoautonomomunicipaldelapaz),
            Trabajos("YPFB", "Analista Financiero", "Atención al Cliente", 6000, "Tarija", 11, 15, "Participarás en la planificación económica, elaboración de presupuestos y análisis de indicadores financieros.", R.drawable.ypfb),
            Trabajos("Nacional Seguros", "Auxiliar de Recursos Humanos", "Atención al Cliente", 3800, "Beni", 8, 16, "Apoyarás en la gestión de contratos, control de asistencia y procesos de reclutamiento interno.", R.drawable.nacionaldeseguros),
            Trabajos("Entel S.A.", "Gestor de Cobranza", "Atención al Cliente", 3000, "Pando", 11, 18, "Contactarás clientes con cuentas pendientes, propondrás planes de pago y actualizarás registros de cobros.", R.drawable.entel),

            Trabajos("JalaSoft", "Desarrollador Android", "Tecnología", 7500, "Santa Cruz", 10, 16, "Buscamos un programador Android para desarrollar, mantener y optimizar aplicaciones móviles de alto rendimiento.", R.drawable.jalasoft),
            Trabajos("QuantumSoft", "Desarrollador Web Full Stack", "Tecnología", 7800, "Cochabamba", 12, 17, "Serás responsable del diseño y desarrollo integral de sistemas web con conexión a bases de datos y APIs.", R.drawable.quantumsoft),
            Trabajos("Digital Hardware", "Técnico de Soporte TI", "Tecnología", 4000, "Sucre", 11, 15, "Brindarás asistencia técnica a usuarios, instalando software, configurando equipos y resolviendo incidencias.", R.drawable.digitalhardware),
            Trabajos("NeoNet Bolivia", "Diseñador UX/UI", "Tecnología", 6000, "Potosí", 8, 16, "Diseñarás experiencias digitales intuitivas, creando interfaces modernas para plataformas móviles y web.", R.drawable.neonetbolivia),
            Trabajos("Banco Unión", "Analista de Ciberseguridad", "Tecnología", 6500, "Oruro", 11, 18, "Monitorearás accesos, gestionarás vulnerabilidades y aplicarás políticas de seguridad informática.", R.drawable.bancounion),
            Trabajos("SmartSystems Bolivia", "Programador Backend", "Tecnología", 5000, "Tarija", 11, 17, "Implementarás la lógica del servidor, bases de datos y sistemas de autenticación de usuarios.", R.drawable.smartsystem),
            Trabajos("E&Y Bolivia", "Analista de Datos", "Tecnología", 6800, "Beni", 11, 16, "Procesarás grandes volúmenes de información para generar reportes estratégicos y apoyar decisiones corporativas.", R.drawable.eybolivia),
            Trabajos("BoliviaTec", "Tester QA", "Tecnología", 4800, "Pando", 7, 15, "Ejecutarás pruebas de software, detectarás errores y colaborarás con el equipo de desarrollo en la mejora continua.", R.drawable.boliviatec),
            Trabajos("RedOne SRL", "Administrador de Redes", "Tecnología", 5500, "La Paz", 13, 17, "Mantendrás operativas las redes internas y servidores, garantizando la seguridad y el rendimiento.", R.drawable.redonesrl),
            Trabajos("StartApp Bolivia", "Desarrollador Flutter", "Tecnología", 6000, "Santa Cruz", 8, 16, "Crearás aplicaciones multiplataforma con Flutter, integrando Firebase y APIs externas.", R.drawable.startapp),

            Trabajos("Cervecería Boliviana Nacional", "Operario de Planta", "Producción", 5200, "Cochabamba", 8, 15, "Operarás equipos de producción y embotellado, garantizando calidad y cumplimiento de normas de seguridad.", R.drawable.cerveceriaboliviananacional),
            Trabajos("FANCESA", "Técnico Electromecánico", "Producción", 4800, "Sucre", 10, 16, "Brindarás mantenimiento preventivo y correctivo a maquinaria industrial en línea de producción.", R.drawable.fancesa),
            Trabajos("PIL Andina", "Empaquetador", "Producción", 4000, "Potosí", 12, 17, "Te encargarás del envasado, etiquetado y control de calidad de productos lácteos.", R.drawable.pilandina),
            Trabajos("Industrias Venado", "Operario de Producción", "Producción", 3800, "Tarija", 12, 16, "Realizarás tareas de ensamblado, limpieza y cumplimiento de estándares de fabricación.", R.drawable.industriasvenado),
            Trabajos("COFAR", "Técnico de Laboratorio", "Producción", 4500, "Beni", 7, 15, "Analizarás muestras y controlarás la calidad de medicamentos en distintas fases de producción.", R.drawable.cofar),
            Trabajos("LABORATORIOS IFA", "Ingeniero Químico", "Producción", 6000, "Pando", 10, 17, "Liderarás procesos de formulación, mezclas y control químico de productos farmacéuticos.", R.drawable.laboratoriosifa),
            Trabajos("AGROVALLE", "Operario Agrícola", "Producción", 3700, "La Paz", 10, 16, "Colaborarás en la cosecha, riego y mantenimiento de cultivos agrícolas bajo supervisión técnica.", R.drawable.agrovalle),
            Trabajos("EMAPA", "Técnico de Almacenamiento", "Producción", 4000, "Santa Cruz", 13, 18, "Controlarás inventario, despacho y recepción de productos en centros de acopio.", R.drawable.emapa),
            Trabajos("PETROBRAS Bolivia", "Supervisor de Campo", "Producción", 6500, "Cochabamba", 13, 17, "Coordinarás personal de mantenimiento, inspeccionarás áreas operativas y elaborarás reportes técnicos.", R.drawable.petrobas),

            Trabajos("Colegio San Agustín", "Profesor de Matemáticas", "Educación", 3500, "Sucre", 8, 16, "Impartirás clases de matemáticas en nivel secundario, planificando actividades y evaluaciones.", R.drawable.colegiosanagustin),
            Trabajos("Universidad Privada Boliviana", "Docente Universitario", "Educación", 6000, "Potosí", 10, 17, "Dictarás clases de ingeniería de sistemas y apoyarás en proyectos de investigación.", R.drawable.upb),
            Trabajos("Instituto CECAP", "Instructor de Informática", "Educación", 3800, "Oruro", 9, 15, "Enseñarás ofimática, diseño y programación a jóvenes y adultos.", R.drawable.institutocecap),
            Trabajos("Kinder Arcoíris", "Maestra de Inicial", "Educación", 2800, "Tarija", 11, 16, "Guiarás el aprendizaje temprano con actividades pedagógicas y recreativas.", R.drawable.kinderarcoiris),
            Trabajos("Instituto Técnico Don Bosco", "Docente de Electrónica", "Educación", 4000, "Beni", 14, 18, "Impartirás materias técnicas y prácticas en electrónica aplicada.", R.drawable.donboso),
            Trabajos("Centro de Idiomas American School", "Profesor de Inglés", "Educación", 3500, "Pando", 9, 17, "Dictarás clases presenciales y virtuales de inglés para distintos niveles.", R.drawable.centrodeidiomasamericanschool),
            Trabajos("Colegio Alemán Santa Cruz", "Coordinador Académico", "Educación", 5000, "La Paz", 11, 16, "Supervisarás docentes, diseñarás planes de estudio y controlarás calidad educativa.", R.drawable.colegioaleman),
            Trabajos("Escuela de Negocios Boliviana", "Instructor de Marketing", "Educación", 6200, "Santa Cruz", 11, 15, "Impartirás clases prácticas sobre estrategias de marca y posicionamiento.", R.drawable.escueladenegociosboliviana),
            Trabajos("Centro de Formación Técnica FOTEC", "Profesor de Redes", "Educación", 3800, "Cochabamba", 9, 17, "Enseñarás configuración de redes LAN, cableado estructurado y mantenimiento.", R.drawable.centrodeformaciontecnica),
            Trabajos("UNIFRANZ", "Tutor Académico", "Educación", 5500, "Sucre", 9, 16, "Orientarás a estudiantes, revisarás trabajos y acompañarás su desarrollo profesional.", R.drawable.unifranz),

            Trabajos("Clínica Foianini", "Enfermero/a Profesional", "Salud", 6000, "Potosí", 11, 17, "Atenderás pacientes hospitalizados, administrarás medicamentos y apoyarás en procedimientos médicos.", R.drawable.clinicafoianini),
            Trabajos("Farmacorp", "Auxiliar de Farmacia", "Salud", 3800, "Oruro", 10, 15, "Atenderás clientes, despacharás medicamentos y controlarás stock.", R.drawable.farmacorp),
            Trabajos("Caja Nacional de Salud", "Médico General", "Salud", 6500, "Tarija", 12, 16, "Brindarás atención médica integral, diagnósticos y prescripción de tratamientos.", R.drawable.cajanacionaldesalud),
            Trabajos("Hospital Japonés", "Técnico de Laboratorio Clínico", "Salud", 5500, "Beni", 10, 18, "Realizarás análisis de sangre, orina y muestras biológicas bajo protocolos establecidos.", R.drawable.hospitaljapones),
            Trabajos("Clínica Santa María", "Fisioterapeuta", "Salud", 4800, "Pando", 10, 17, "Desarrollarás terapias de rehabilitación física y motriz para pacientes con lesiones.", R.drawable.clinicasantamaria),
            Trabajos("Cruz Roja Boliviana", "Paramédico", "Salud", 4000, "La Paz", 10, 16, "Atenderás emergencias, brindarás primeros auxilios y apoyo en operativos de salud.", R.drawable.cruzroja),
            Trabajos("Farmacias Chávez", "Vendedor de Farmacia", "Salud", 3500, "Santa Cruz", 10, 15, "Asesorarás a clientes en la compra de medicamentos y productos de salud.", R.drawable.farmaciaschavez),
            Trabajos("Centro Odontológico SonrisaPlus", "Asistente Dental", "Salud", 5000, "Cochabamba", 13, 17, "Prepararás instrumentos, asistirás al odontólogo y atenderás pacientes.", R.drawable.centroodontologicosonrisaplus),
            Trabajos("Hospital Obrero", "Bioquímico Clínico", "Salud", 6800, "Sucre", 8, 16, "Analizarás muestras y elaborarás informes para diagnóstico médico.", R.drawable.hospitalobrero),
            Trabajos("Laboratorio Prosalud", "Técnico de Rayos X", "Salud", 4500, "Potosí", 11, 18, "Realizarás estudios radiológicos siguiendo normas de seguridad y precisión.", R.drawable.laboratorioprosalud),

            Trabajos("Transportes Bolinter", "Chofer de Reparto", "Logística", 3500, "Oruro", 10, 16, "Realizarás entregas de productos en rutas asignadas, garantizando puntualidad y seguridad.", R.drawable.transportesbolinter),
            Trabajos("Disprofar", "Auxiliar de Almacén", "Logística", 3800, "Tarija", 12, 17, "Controlarás entradas y salidas de productos, organizando inventarios.", R.drawable.disprofar),
            Trabajos("IMCRUZ", "Encargado de Logística", "Logística", 5000, "Beni", 11, 15, "Coordinarás despachos, rutas de transporte y control de stock automotriz.", R.drawable.imcruz),
            Trabajos("SACI Bolivia", "Asistente de Logística y Despacho", "Logística", 4200, "Pando", 8, 16, "Apoyarás la planificación y control de inventario de materiales, asegurando entregas eficientes.", R.drawable.saci),
            Trabajos("Toborochi Express", "Repartidor", "Logística", 3200, "La Paz", 11, 18, "Entregarás pedidos a clientes manteniendo atención cordial y cumplimiento de tiempos.", R.drawable.toborochiexpress),
            Trabajos("Almacenes Santa Cruz", "Supervisor de Inventario", "Logística", 4000, "Santa Cruz", 11, 17, "Gestionarás el control de existencias y elaboración de reportes.", R.drawable.almacenessantacruz),
            Trabajos("K'ULI Transport", "Coordinador de Rutas", "Logística", 5500, "Cochabamba", 11, 16, "Planificarás horarios de entrega y coordinarás flota vehicular.", R.drawable.kulitransport),
            Trabajos("Bolivian Cargo", "Analista de Operaciones Logísticas", "Logística", 6000, "Sucre", 11, 15, "Monitorearás procesos de transporte nacional e internacional.", R.drawable.boliviacargo),
            Trabajos("COBOCE", "Operador de Montacargas", "Logística", 4500, "Potosí", 9, 17, "Manipularás cargas y asistirás en la descarga de materiales pesados.", R.drawable.coboce),
            Trabajos("Post Express", "Encargado de Paquetería", "Logística", 3800, "Oruro", 9, 16, "Clasificarás, embalarás y despacharás paquetes garantizando su entrega segura.", R.drawable.postexpress),

            Trabajos("Agencia Creativa Pixel", "Diseñador Gráfico", "Marketing", 5000, "Tarija", 11, 17, "Crearás material publicitario, branding y contenido visual para redes sociales.", R.drawable.agenciacreativapixel),
            Trabajos("BoliviaModa", "Community Manager", "Marketing", 4800, "Beni", 10, 15, "Gestionarás redes sociales, campañas y atención digital a clientes.", R.drawable.boliviamoda),
            Trabajos("Cerveza Paceña", "Ejecutivo de Marketing", "Marketing", 6500, "La Paz", 14, 18, "Coordinarás estrategias de publicidad, promociones y posicionamiento de marca.", R.drawable.pacena),
            Trabajos("Cinemark Bolivia", "Asistente de Publicidad", "Marketing", 3800, "Santa Cruz", 9, 17, "Apoyarás la ejecución de campañas locales y eventos promocionales.", R.drawable.cinemark),
            Trabajos("Publired SRL", "Redactor Publicitario", "Marketing", 5200, "Cochabamba", 9, 16, "Crearás textos persuasivos para campañas, anuncios y redes sociales.", R.drawable.publiredsrl),
            Trabajos("Canal Universitario TVU", "Productor Audiovisual", "Marketing", 4500, "Sucre", 9, 15, "Planificarás y grabarás programas, gestionando cronogramas y equipos.", R.drawable.canaluniversitariotvu),
            Trabajos("Radio Fides", "Locutor y Editor de Contenido", "Marketing", 3800, "Potosí", 12, 17, "Conducirás programas radiales y editarás contenido informativo.", R.drawable.radiofides),
            Trabajos("Imprenta Grafisur", "Diseñador Preprensa", "Marketing", 3500, "Oruro", 12, 16, "Prepararás archivos gráficos para impresión, asegurando calidad y color.", R.drawable.imprentafrafisur),
            Trabajos("Agencia Andina", "Fotógrafo Profesional", "Marketing", 6000, "Tarija", 10, 18, "Capturarás y editarás imágenes para publicidad, medios y eventos corporativos.", R.drawable.agenciaandina),

            Trabajos("Hotel Los Tajibos", "Recepcionista de Hotel", "Turismo", 5000, "Beni", 10, 17, "Atenderás huéspedes, gestionarás reservas y ofrecerás información turística.", R.drawable.hotellostajibos),
            Trabajos("Restaurante Gustu", "Cocinero Principal", "Turismo", 4800, "Pando", 9, 15, "Elaborarás platos de autor, controlando estándares de calidad y presentación.", R.drawable.gusto),
            Trabajos("Café Alexander", "Barista", "Turismo", 3500, "La Paz", 11, 16, "Prepararás bebidas calientes y frías, brindando una experiencia agradable al cliente.", R.drawable.alexandercoffee),
            Trabajos("Amaszonas", "Tripulante de Cabina", "Turismo", 6000, "Santa Cruz", 14, 18, "Atenderás pasajeros durante vuelos y asegurarás el cumplimiento de normas de seguridad.", R.drawable.amaszonas),
            Trabajos("Agencia de Viajes Tropical Tours", "Agente de Viajes", "Turismo", 4200, "Cochabamba", 9, 17, "Venderás paquetes turísticos, coordinarás itinerarios y asesorarás clientes.", R.drawable.agenciadeviajestropicaltours),
            Trabajos("Hard Rock Café", "Mesero", "Turismo", 3500, "Potosí", 8, 15, "Atenderás mesas, servirás pedidos y garantizarás un servicio de calidad.", R.drawable.hardrock),
            Trabajos("Glovo Bolivia", "Repartidor Delivery", "Turismo", 3200, "Oruro", 11, 17, "Realizarás entregas a domicilio, cumpliendo rutas y horarios establecidos.", R.drawable.glovobolivia),
            Trabajos("Casa Kolping", "Chef Ejecutivo", "Turismo", 4500, "Tarija", 11, 16, "Supervisarás cocina, menú y control de insumos.", R.drawable.casakolping),

            Trabajos("COBOCE Construcciones", "Maestro de Obra", "Construcción", 5500, "Pando", 13, 17, "Supervisarás personal, materiales y cumplimiento de planos de construcción.", R.drawable.coboceconstrucciones),
            Trabajos("ElectroBol", "Técnico Electricista", "Construcción", 4200, "La Paz", 7, 15, "Realizarás instalaciones eléctricas y mantenimiento de redes industriales.", R.drawable.electrobol),
            Trabajos("Ferretería El Tornillo", "Vendedor Técnico", "Construcción", 3000, "Cochabamba", 11, 18, "Atenderás clientes y asesorarás sobre herramientas y materiales.", R.drawable.ferreteriaeltornillo),
            Trabajos("Soboce Prefabricados", "Operario de Planta de Concreto", "Construcción", 4800, "Sucre", 11, 17, "Prepararás mezclas, controlarás maquinaria y supervisarás calidad.", R.drawable.soboceprefabricados),
            Trabajos("Mecatrónica Bolivia", "Técnico en Automatización", "Construcción", 5200, "Potosí", 11, 16, "Instalarás sensores, tableros y sistemas automatizados.", R.drawable.mecatronicabolivia),
            Trabajos("TechSol", "Ingeniero en Energías Renovables", "Construcción", 6500, "Oruro", 11, 15, "Desarrollarás proyectos solares y eólicos en zonas rurales.", R.drawable.techsol),
            Trabajos("Servicios Eléctricos del Sur", "Ayudante de Instalaciones", "Construcción", 3800, "Tarija", 9, 17, "Apoyarás en montaje de cableado, canaletas y equipos eléctricos.", R.drawable.sevicioselectronicosdelsur),
            Trabajos("Constructora Norte", "Topógrafo", "Construcción", 4500, "Beni", 10, 16, "Levantarás planos y mediciones de terreno para obras civiles.", R.drawable.constructoranorte),
            Trabajos("Boltec", "Técnico en Climatización", "Construcción", 5800, "Pando", 14, 18, "Instalarás y mantendrás equipos de aire acondicionado y refrigeración.", R.drawable.boltec)
        )

    }


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

        for (i in 0..listaTotalTrabajos.size - 1) {
            if (listaTotalTrabajos[i].salario >= 2000) {
                trabajosRecomendados.add(listaTotalTrabajos[i])
            }
        }

        adpater.addDataCards(trabajosRecomendados)

        binding.recyclerPantallaRecomendados.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerPantallaRecomendados.adapter = adpater


        binding.perfilPantallaPrincipal.setOnClickListener {

            val intentCambioDePantallaPerfilActivity =
                Intent(context, PantallaPerfilActivity::class.java)
            startActivity(intentCambioDePantallaPerfilActivity)
        }

        binding.iconoTrabajosPostulados.setOnClickListener {
            val intentVolverPantallaPrincipal =
                Intent(context, TrabajosPostuladosActivity::class.java)
            startActivity(intentVolverPantallaPrincipal)
        }


        binding.iconoBuscar.setOnClickListener {

            val mandarTrabajosaBusqueda: Intent = Intent(context, BusquedaActivity::class.java)
            mandarTrabajosaBusqueda.apply {
                putExtra("listaTrabajos", Json.encodeToString(listaTotalTrabajos))
            }

            startActivity(mandarTrabajosaBusqueda)
        }

    }
}