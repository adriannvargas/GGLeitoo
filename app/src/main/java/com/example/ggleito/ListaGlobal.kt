package com.example.ggleito

import android.app.Application
import com.example.ggleito.dataclasses.Trabajos

class ListaGlobal : Application() {

    companion object{
        var listaTrabajosTotal: MutableList<Trabajos> = mutableListOf()
    }

    override fun onCreate() {
        super.onCreate()
        inicializarTrabajos()

    }

    fun inicializarTrabajos(){
        listaTrabajosTotal.clear()
        listaTrabajosTotal.addAll(crearTrabajos())
    }

    fun crearTrabajos(): List<Trabajos> {
        return listOf(
            Trabajos("Soboce","Asistente de Logistica y Despacho" ,"Marketing", 3000, "La Paz", 8,3, "Integramos a un Asistente de Logistica. Apoyaras la planificacion y el control de inventario de materiales de construccion, coordinando rutas de despacho para asegurar la entrega eficiente de nuestros productos.", R.drawable.soboce),

            Trabajos(
                "Banco Mercantil SC","Ejecutivo de Servicios y Plataforma","Logistica", 4000, "La Paz", 9,5, " Oportunidad para Ejecutivos de Servicios. Tu rol sera crucial en la atencion al cliente en plataforma, la apertura de cuentas y la promocion de productos bancarios, garantizando un servicio de excelencia.", R.drawable.bmsc),
            Trabajos(
                "Hipermaxi", "Personal Operativo/Cajero","Marketing",2750, "Cochabamba", 7,3, "Personal Operativo/Cajero Personal Operativo para diversas areas de tienda. Tu enfoque sera en el servicio al cliente, la reposicion de mercaderia y el manejo de caja, siendo la cara de Hipermaxi ante nuestros clientes.", R.drawable.hipermaxi),
            Trabajos(
                "Tigo Bolivia","Asesor Comercial/Ventas", "Tecnologia",4500, "Santa Cruz", 10,6, " Unete a Tigo como Asesor Comercial. Seras responsable de la venta y promocion de nuestros servicios (telefonia, internet, TV) en puntos de venta o call center, alcanzando metas mensuales.", R.drawable.tigo),
            Trabajos(
                "Toyota Bolivia", "Asesor de Ventas de Vehiculos","Produccion",4500, "Santa Cruz", 10,6, " Contratamos Asesores de Venta apasionados por la industria automotriz. Promociona y vende nuestra flota de vehiculos, gestionando la cartera de clientes y asegurando una experiencia de compra premium.", R.drawable.toyota),
            Trabajos("Burger King", "Supervisor de Turno","Atencion al cliente",4500, "Santa Cruz", 10,6, " Buscamos Supervisores de Turno con liderazgo. Gestionaras las operaciones diarias del restaurante, capacitaras al personal y aseguraras el cumplimiento de estandares de calidad y servicio al cliente.", R.drawable.burguerking),

            Trabajos("Banco BISA", "Cajero Bancario", "Atencion al Cliente", 4200, "Santa Cruz", 9, 17, "Forma parte de nuestro equipo realizando operaciones de caja, depositos y retiros, garantizando precision y atencion cordial a los clientes.", R.drawable.bancobisa),

            Trabajos("CRE R.L.", "Asistente Administrativo", "Atencion al Cliente", 3800, "Cochabamba", 8, 15, "Apoyaras la gestion de documentos, control de archivo y atencion a socios, asegurando el cumplimiento de procesos administrativos internos.", R.drawable.crerl),
            Trabajos("VIVA Bolivia", "Promotor de Ventas", "Atencion al Cliente", 3000, "Sucre", 12, 18, "Seras responsable de ofrecer planes y servicios moviles en puntos de venta y ferias, orientando a los clientes para optimizar su experiencia.", R.drawable.viva),
            Trabajos("Gobierno Autonomo Municipal de La Paz", "Secretaria Ejecutiva", "Atencion al Cliente", 3200, "Oruro", 12, 17, "Gestionaras la agenda institucional, elaboracion de documentos y coordinacion de reuniones internas.", R.drawable.gobiernoautonomomunicipaldelapaz),
            Trabajos("YPFB", "Analista Financiero", "Atencion al Cliente", 6000, "Tarija", 11, 15, "Participaras en la planificacion economica, elaboracion de presupuestos y analisis de indicadores financieros.", R.drawable.ypfb),
            Trabajos("Nacional Seguros", "Auxiliar de Recursos Humanos", "Atencion al Cliente", 3800, "Beni", 8, 16, "Apoyaras en la gestion de contratos, control de asistencia y procesos de reclutamiento interno.", R.drawable.nacionaldeseguros),
            Trabajos("Entel S.A.", "Gestor de Cobranza", "Atencion al Cliente", 3000, "Pando", 11, 18, "Contactaras clientes con cuentas pendientes, propondras planes de pago y actualizaras registros de cobros.", R.drawable.entel),

            Trabajos("JalaSoft", "Desarrollador Android", "Tecnologia", 7500, "Santa Cruz", 10, 16, "Buscamos un programador Android para desarrollar, mantener y optimizar aplicaciones moviles de alto rendimiento.", R.drawable.jalasoft),
            Trabajos("QuantumSoft", "Desarrollador Web Full Stack", "Tecnologia", 7800, "Cochabamba", 12, 17, "Seras responsable del diseno y desarrollo integral de sistemas web con conexion a bases de datos y APIs.", R.drawable.quantumsoft),
            Trabajos("Digital Hardware", "Tecnico de Soporte TI", "Tecnologia", 4000, "Sucre", 11, 15, "Brindaras asistencia tecnica a usuarios, instalando software, configurando equipos y resolviendo incidencias.", R.drawable.digitalhardware),
            Trabajos("NeoNet Bolivia", "Disenador UX/UI", "Tecnologia", 6000, "Potosi", 8, 16, "Disenaras experiencias digitales intuitivas, creando interfaces modernas para plataformas moviles y web.", R.drawable.neonetbolivia),
            Trabajos("Banco Union", "Analista de Ciberseguridad", "Tecnologia", 6500, "Oruro", 11, 18, "Monitorearas accesos, gestionaras vulnerabilidades y aplicaras politicas de seguridad informatica.", R.drawable.bancounion),
            Trabajos("SmartSystems Bolivia", "Programador Backend", "Tecnologia", 5000, "Tarija", 11, 17, "Implementaras la logica del servidor, bases de datos y sistemas de autenticacion de usuarios.", R.drawable.smartsystem),
            Trabajos("E&Y Bolivia", "Analista de Datos", "Tecnologia", 6800, "Beni", 11, 16, "Procesaras grandes volumenes de informacion para generar reportes estrategicos y apoyar decisiones corporativas.", R.drawable.eybolivia),
            Trabajos("BoliviaTec", "Tester QA", "Tecnologia", 4800, "Pando", 7, 15, "Ejecutaras pruebas de software, detectaras errores y colaboraras con el equipo de desarrollo en la mejora continua.", R.drawable.boliviatec),
            Trabajos("RedOne SRL", "Administrador de Redes", "Tecnologia", 5500, "La Paz", 13, 17, "Mantendras operativas las redes internas y servidores, garantizando la seguridad y el rendimiento.", R.drawable.redonesrl),
            Trabajos("StartApp Bolivia", "Desarrollador Flutter", "Tecnologia", 6000, "Santa Cruz", 8, 16, "Crearas aplicaciones multiplataforma con Flutter, integrando Firebase y APIs externas.", R.drawable.startapp),

            Trabajos("Cerveceria Boliviana Nacional", "Operario de Planta", "Produccion", 5200, "Cochabamba", 8, 15, "Operaras equipos de produccion y embotellado, garantizando calidad y cumplimiento de normas de seguridad.", R.drawable.cerveceriaboliviananacional),
            Trabajos("FANCESA", "Tecnico Electromecanico", "Produccion", 4800, "Sucre", 10, 16, "Brindaras mantenimiento preventivo y correctivo a maquinaria industrial en linea de produccion.", R.drawable.fancesa),
            Trabajos("PIL Andina", "Empaquetador", "Produccion", 4000, "Potosi", 12, 17, "Te encargaras del envasado, etiquetado y control de calidad de productos lacteos.", R.drawable.pilandina),
            Trabajos("Industrias Venado", "Operario de Produccion", "Produccion", 3800, "Tarija", 12, 16, "Realizaras tareas de ensamblado, limpieza y cumplimiento de estandares de fabricacion.", R.drawable.industriasvenado),
            Trabajos("COFAR", "Tecnico de Laboratorio", "Produccion", 4500, "Beni", 7, 15, "Analizaras muestras y controlaras la calidad de medicamentos en distintas fases de produccion.", R.drawable.cofar),
            Trabajos("LABORATORIOS IFA", "Ingeniero Quimico", "Produccion", 6000, "Pando", 10, 17, "Lideraras procesos de formulacion, mezclas y control quimico de productos farmaceuticos.", R.drawable.laboratoriosifa),
            Trabajos("AGROVALLE", "Operario Agricola", "Produccion", 3700, "La Paz", 10, 16, "Colaboraras en la cosecha, riego y mantenimiento de cultivos agricolas bajo supervision tecnica.", R.drawable.agrovalle),
            Trabajos("EMAPA", "Tecnico de Almacenamiento", "Produccion", 4000, "Santa Cruz", 13, 18, "Controlaras inventario, despacho y recepcion de productos en centros de acopio.", R.drawable.emapa),
            Trabajos("PETROBRAS Bolivia", "Supervisor de Campo", "Produccion", 6500, "Cochabamba", 13, 17, "Coordinaras personal de mantenimiento, inspeccionaras areas operativas y elaboraras reportes tecnicos.", R.drawable.petrobas),

            Trabajos("Colegio San Agustin", "Profesor de Matematicas", "Educacion", 3500, "Sucre", 8, 16, "Impartiras clases de matematicas en nivel secundario, planificando actividades y evaluaciones.", R.drawable.colegiosanagustin),
            Trabajos("Universidad Privada Boliviana", "Docente Universitario", "Educacion", 6000, "Potosi", 10, 17, "Dictaras clases de ingenieria de sistemas y apoyaras en proyectos de investigacion.", R.drawable.upb),
            Trabajos("Instituto CECAP", "Instructor de Informatica", "Educacion", 3800, "Oruro", 9, 15, "Ensenaras ofimatica, diseno y programacion a jovenes y adultos.", R.drawable.institutocecap),
            Trabajos("Kinder Arcoiris", "Maestra de Inicial", "Educacion", 2800, "Tarija", 11, 16, "Guiaras el aprendizaje temprano con actividades pedagogicas y recreativas.", R.drawable.kinderarcoiris),
            Trabajos("Instituto Tecnico Don Bosco", "Docente de Electronica", "Educacion", 4000, "Beni", 14, 18, "Impartiras materias tecnicas y practicas en electronica aplicada.", R.drawable.donboso),
            Trabajos("Centro de Idiomas American School", "Profesor de Ingles", "Educacion", 3500, "Pando", 9, 17, "Dictaras clases presenciales y virtuales de ingles para distintos niveles.", R.drawable.centrodeidiomasamericanschool),
            Trabajos("Colegio Aleman Santa Cruz", "Coordinador Academico", "Educacion", 5000, "La Paz", 11, 16, "Supervisaras docentes, disenaras planes de estudio y controlaras calidad educativa.", R.drawable.colegioaleman),
            Trabajos("Escuela de Negocios Boliviana", "Instructor de Marketing", "Educacion", 6200, "Santa Cruz", 11, 15, "Impartiras clases practicas sobre estrategias de marca y posicionamiento.", R.drawable.escueladenegociosboliviana),
            Trabajos("Centro de Formacion Tecnica FOTEC", "Profesor de Redes", "Educacion", 3800, "Cochabamba", 9, 17, "Ensenaras configuracion de redes LAN, cableado estructurado y mantenimiento.", R.drawable.centrodeformaciontecnica),
            Trabajos("UNIFRANZ", "Tutor Academico", "Educacion", 5500, "Sucre", 9, 16, "Orientaras a estudiantes, revisaras trabajos y acompanaras su desarrollo profesional.", R.drawable.unifranz),

            Trabajos("Clinica Foianini", "Enfermero/a Profesional", "Salud", 6000, "Potosi", 11, 17, "Atenderas pacientes hospitalizados, administraras medicamentos y apoyaras en procedimientos medicos.", R.drawable.clinicafoianini),
            Trabajos("Farmacorp", "Auxiliar de Farmacia", "Salud", 3800, "Oruro", 10, 15, "Atenderas clientes, despacharas medicamentos y controlaras stock.", R.drawable.farmacorp),
            Trabajos("Caja Nacional de Salud", "Medico General", "Salud", 6500, "Tarija", 12, 16, "Brindaras atencion medica integral, diagnosticos y prescripcion de tratamientos.", R.drawable.cajanacionaldesalud),
            Trabajos("Hospital Japones", "Tecnico de Laboratorio Clinico", "Salud", 5500, "Beni", 10, 18, "Realizaras analisis de sangre, orina y muestras biologicas bajo protocolos establecidos.", R.drawable.hospitaljapones),
            Trabajos("Clinica Santa Maria", "Fisioterapeuta", "Salud", 4800, "Pando", 10, 17, "Desarrollaras terapias de rehabilitacion fisica y motriz para pacientes con lesiones.", R.drawable.clinicasantamaria),
            Trabajos("Cruz Roja Boliviana", "Paramedico", "Salud", 4000, "La Paz", 10, 16, "Atenderas emergencias, brindaras primeros auxilios y apoyo en operativos de salud.", R.drawable.cruzroja),
            Trabajos("Farmacias Chavez", "Vendedor de Farmacia", "Salud", 3500, "Santa Cruz", 10, 15, "Asesoraras a clientes en la compra de medicamentos y productos de salud.", R.drawable.farmaciaschavez),
            Trabajos("Centro Odontologico SonrisaPlus", "Asistente Dental", "Salud", 5000, "Cochabamba", 13, 17, "Prepararas instrumentos, asistiras al odontologo y atenderas pacientes.", R.drawable.centroodontologicosonrisaplus),
            Trabajos("Hospital Obrero", "Bioquimico Clinico", "Salud", 6800, "Sucre", 8, 16, "Analizaras muestras y elaboraras informes para diagnostico medico.", R.drawable.hospitalobrero),
            Trabajos("Laboratorio Prosalud", "Tecnico de Rayos X", "Salud", 4500, "Potosi", 11, 18, "Realizaras estudios radiologicos siguiendo normas de seguridad y precision.", R.drawable.laboratorioprosalud),

            Trabajos("Transportes Bolinter", "Chofer de Reparto", "Logistica", 3500, "Oruro", 10, 16, "Realizaras entregas de productos en rutas asignadas, garantizando puntualidad y seguridad.", R.drawable.transportesbolinter),
            Trabajos("Disprofar", "Auxiliar de Almacen", "Logistica", 3800, "Tarija", 12, 17, "Controlaras entradas y salidas de productos, organizando inventarios.", R.drawable.disprofar),
            Trabajos("IMCRUZ", "Encargado de Logistica", "Logistica", 5000, "Beni", 11, 15, "Coordinaras despachos, rutas de transporte y control de stock automotriz.", R.drawable.imcruz),
            Trabajos("SACI Bolivia", "Asistente de Logistica y Despacho", "Logistica", 4200, "Pando", 8, 16, "Apoyaras la planificacion y control de inventario de materiales, asegurando entregas eficientes.", R.drawable.saci),
            Trabajos("Toborochi Express", "Repartidor", "Logistica", 3200, "La Paz", 11, 18, "Entregaras pedidos a clientes manteniendo atencion cordial y cumplimiento de tiempos.", R.drawable.toborochiexpress),
            Trabajos("Almacenes Santa Cruz", "Supervisor de Inventario", "Logistica", 4000, "Santa Cruz", 11, 17, "Gestionaras el control de existencias y elaboracion de reportes.", R.drawable.almacenessantacruz),
            Trabajos("K'ULI Transport", "Coordinador de Rutas", "Logistica", 5500, "Cochabamba", 11, 16, "Planificaras horarios de entrega y coordinaras flota vehicular.", R.drawable.kulitransport),
            Trabajos("Bolivian Cargo", "Analista de Operaciones Logisticas", "Logistica", 6000, "Sucre", 11, 15, "Monitorearas procesos de transporte nacional e internacional.", R.drawable.boliviacargo),
            Trabajos("COBOCE", "Operador de Montacargas", "Logistica", 4500, "Potosi", 9, 17, "Manipularas cargas y asistiras en la descarga de materiales pesados.", R.drawable.coboce),
            Trabajos("Post Express", "Encargado de Paqueteria", "Logistica", 3800, "Oruro", 9, 16, "Clasificaras, embalaras y despacharas paquetes garantizando su entrega segura.", R.drawable.postexpress),

            Trabajos("Agencia Creativa Pixel", "Disenador Grafico", "Marketing", 5000, "Tarija", 11, 17, "Crearas material publicitario, branding y contenido visual para redes sociales.", R.drawable.agenciacreativapixel),
            Trabajos("BoliviaModa", "Community Manager", "Marketing", 4800, "Beni", 10, 15, "Gestionaras redes sociales, campanas y atencion digital a clientes.", R.drawable.boliviamoda),
            Trabajos("Cerveza Pacena", "Ejecutivo de Marketing", "Marketing", 6500, "La Paz", 14, 18, "Coordinaras estrategias de publicidad, promociones y posicionamiento de marca.", R.drawable.pacena),
            Trabajos("Cinemark Bolivia", "Asistente de Publicidad", "Marketing", 3800, "Santa Cruz", 9, 17, "Apoyaras la ejecucion de campanas locales y eventos promocionales.", R.drawable.cinemark),
            Trabajos("Publired SRL", "Redactor Publicitario", "Marketing", 5200, "Cochabamba", 9, 16, "Crearas textos persuasivos para campanas, anuncios y redes sociales.", R.drawable.publiredsrl),
            Trabajos("Canal Universitario TVU", "Productor Audiovisual", "Marketing", 4500, "Sucre", 9, 15, "Planificaras y grabaras programas, gestionando cronogramas y equipos.", R.drawable.canaluniversitariotvu),
            Trabajos("Radio Fides", "Locutor y Editor de Contenido", "Marketing", 3800, "Potosi", 12, 17, "Conduciras programas radiales y editaras contenido informativo.", R.drawable.radiofides),
            Trabajos("Imprenta Grafisur", "Disenador Preprensa", "Marketing", 3500, "Oruro", 12, 16, "Prepararas archivos graficos para impresion, asegurando calidad y color.", R.drawable.imprentafrafisur),
            Trabajos("Agencia Andina", "Fotografo Profesional", "Marketing", 6000, "Tarija", 10, 18, "Capturaras y editaras imagenes para publicidad, medios y eventos corporativos.", R.drawable.agenciaandina),

            Trabajos("Hotel Los Tajibos", "Recepcionista de Hotel", "Turismo", 5000, "Beni", 10, 17, "Atenderas huespedes, gestionaras reservas y ofreceras informacion turistica.", R.drawable.hotellostajibos),
            Trabajos("Restaurante Gustu", "Cocinero Principal", "Turismo", 4800, "Pando", 9, 15, "Elaboraras platos de autor, controlando estandares de calidad y presentacion.", R.drawable.gusto),
            Trabajos("Cafe Alexander", "Barista", "Turismo", 3500, "La Paz", 11, 16, "Prepararas bebidas calientes y frias, brindando una experiencia agradable al cliente.", R.drawable.alexandercoffee),
            Trabajos("Amaszonas", "Tripulante de Cabina", "Turismo", 6000, "Santa Cruz", 14, 18, "Atenderas pasajeros durante vuelos y aseguraras el cumplimiento de normas de seguridad.", R.drawable.amaszonas),
            Trabajos("Agencia de Viajes Tropical Tours", "Agente de Viajes", "Turismo", 4200, "Cochabamba", 9, 17, "Venderas paquetes turisticos, coordinaras itinerarios y asesoraras clientes.", R.drawable.agenciadeviajestropicaltours),
            Trabajos("Hard Rock Cafe", "Mesero", "Turismo", 3500, "Potosi", 8, 15, "Atenderas mesas, serviras pedidos y garantizaras un servicio de calidad.", R.drawable.hardrock),
            Trabajos("Glovo Bolivia", "Repartidor Delivery", "Turismo", 3200, "Oruro", 11, 17, "Realizaras entregas a domicilio, cumpliendo rutas y horarios establecidos.", R.drawable.glovobolivia),
            Trabajos("Casa Kolping", "Chef Ejecutivo", "Turismo", 4500, "Tarija", 11, 16, "Supervisaras cocina, menu y control de insumos.", R.drawable.casakolping),

            Trabajos("COBOCE Construcciones", "Maestro de Obra", "Construccion", 5500, "Pando", 13, 17, "Supervisaras personal, materiales y cumplimiento de planos de construccion.", R.drawable.coboceconstrucciones),
            Trabajos("ElectroBol", "Tecnico Electricista", "Construccion", 4200, "La Paz", 7, 15, "Realizaras instalaciones electricas y mantenimiento de redes industriales.", R.drawable.electrobol),
            Trabajos("Ferreteria El Tornillo", "Vendedor Tecnico", "Construccion", 3000, "Cochabamba", 11, 18, "Atenderas clientes y asesoraras sobre herramientas y materiales.", R.drawable.ferreteriaeltornillo),
            Trabajos("Soboce Prefabricados", "Operario de Planta de Concreto", "Construccion", 4800, "Sucre", 11, 17, "Prepararas mezclas, controlaras maquinaria y supervisaras calidad.", R.drawable.soboceprefabricados),
            Trabajos("Mecatronica Bolivia", "Tecnico en Automatizacion", "Construccion", 5200, "Potosi", 11, 16, "Instalaras sensores, tableros y sistemas automatizados.", R.drawable.mecatronicabolivia),
            Trabajos("TechSol", "Ingeniero en Energias Renovables", "Construccion", 6500, "Oruro", 11, 15, "Desarrollaras proyectos solares y eolicos en zonas rurales.", R.drawable.techsol),
            Trabajos("Servicios Electricos del Sur", "Ayudante de Instalaciones", "Construccion", 3800, "Tarija", 9, 17, "Apoyaras en montaje de cableado, canaletas y equipos electricos.", R.drawable.sevicioselectronicosdelsur),
            Trabajos("Constructora Norte", "Topografo", "Construccion", 4500, "Beni", 10, 16, "Levantaras planos y mediciones de terreno para obras civiles.", R.drawable.constructoranorte),
            Trabajos("Boltec", "Tecnico en Climatizacion", "Construccion", 5800, "Pando", 14, 18, "Instalaras y mantendras equipos de aire acondicionado y refrigeracion.", R.drawable.boltec),
            Trabajos("Banco Nacional de Bolivia", "Analista Financiero Senior", "Atencion al Cliente", 8500, "La Paz", 8, 16, "Analizaras estados financieros y desarrollaras estrategias de crecimiento para clientes corporativos.", R.drawable.bnb),
            Trabajos("Lloyd Aereo Boliviano", "Piloto Comercial", "Logistica", 12000, "Santa Cruz", 10, 18, "Operaras aeronaves en rutas nacionales garantizando seguridad y puntualidad.", R.drawable.lloydaereoboliviano),
            Trabajos("Cerveceria Taquina", "Gerente de Produccion", "Produccion", 9500, "Cochabamba", 9, 15, "Dirigiras toda la linea de produccion optimizando procesos y estandares de calidad.", R.drawable.cerveceriataquina),
            Trabajos("Laboratorios Bago", "Investigador Farmaceutico", "Salud", 8800, "Sucre", 8, 14, "Desarrollaras nuevos farmacos y participaras en estudios clinicos innovadores.", R.drawable.bago),
            Trabajos("Bolivia Gas & Energy", "Ingeniero de Petroleo", "Produccion", 11000, "Tarija", 10, 17, "Supervisaras operaciones de extraccion y procesamiento de gas natural.", R.drawable.gasandenergy),
            Trabajos("Universidad San Francisco", "Catedratico Investigador", "Educacion", 8200, "Chuquisaca", 7, 12, "Impartiras catedras universitarias y lideraras proyectos de investigacion.", R.drawable.universidadsanfrancisco),
            Trabajos("Clinica Los Olivos", "Cirujano General", "Salud", 15000, "La Paz", 11, 18, "Realizaras intervenciones quirurgicas y coordinaras el area de cirugia.", R.drawable.clinicalosolivos),
            Trabajos("Banco Fassil", "Gerente de Sucursal", "Atencion al Cliente", 9200, "Santa Cruz", 9, 16, "Gestionaras operaciones bancarias y equipo de trabajo en agencia principal.", R.drawable.bancofassil),
            Trabajos("Cotecbol", "Ingeniero Civil", "Construccion", 8700, "Cochabamba", 8, 15, "Disenaras estructuras para obras de infraestructura vial y edificacion.", R.drawable.cotecbol),
            Trabajos("Datalytics Bolivia", "Cientifico de Datos", "Tecnologia", 9800, "La Paz", 10, 17, "Aplicaras machine learning para resolver problemas complejos de negocio.", R.drawable.datalyticsbolivia),

            Trabajos("Aerosur", "Jefe de Cabina", "Logistica", 8100, "Santa Cruz", 12, 18, "Coordinaras al equipo de tripulantes y garantizaras servicio de excelencia.", R.drawable.aerosur),
            Trabajos("Fabricato", "Disenador Textil", "Produccion", 7600, "Oruro", 9, 16, "Crearas colecciones de moda y desarrollaras nuevos tejidos textiles.", R.drawable.fabricato),
            Trabajos("Bolivian Gold", "Geologo Minero", "Produccion", 10500, "Potosi", 8, 15, "Realizaras prospeccion y evaluacion de yacimientos minerales.", R.drawable.boliviangold),
            Trabajos("Seguros America", "Actuario Senior", "Atencion al Cliente", 8900, "Beni", 7, 14, "Calcularas primas de seguros y modelaras riesgos financieros.", R.drawable.segurosamerica),
            Trabajos("Telefonica Celular", "Arquitecto de Redes", "Tecnologia", 9400, "Pando", 10, 16, "Disenaras infraestructura de telecomunicaciones 5G y fibra optica.", R.drawable.telefonicacelular),
            Trabajos("Hospital de Clinicas", "Cardiologo", "Salud", 16000, "La Paz", 12, 19, "Especialista en procedimientos cardiacos invasivos y pacientes criticos.", R.drawable.hospitaldeclinicas),
            Trabajos("Constructora Boliviana", "Director de Obras", "Construccion", 10200, "Santa Cruz", 9, 16, "Gestionaras proyectos de construccion desde planificacion hasta entrega.", R.drawable.constructoraboliviana),
            Trabajos("Softtek Andes", "DevOps Engineer", "Tecnologia", 8600, "Cochabamba", 8, 14, "Automatizaras procesos de integracion y despliegue continuo.", R.drawable.softtekandes),
            Trabajos("Bolivia TV", "Productor Ejecutivo", "Marketing", 7800, "La Paz", 11, 17, "Crearas y dirigiras programas de television con alcance nacional.", R.drawable.boliviatv),
            Trabajos("Agua del Illimani", "Ingeniero Ambiental", "Produccion", 8200, "La Paz", 7, 13, "Gestionaras proyectos de tratamiento de agua y control ambiental.", R.drawable.aguadelillimani),

            Trabajos("Camara de Industria", "Consultor Estrategico", "Marketing", 9500, "Santa Cruz", 9, 15, "Asesoraras a empresas en planes de expansion y competitividad.", R.drawable.camaradeindustria),
            Trabajos("Bolivian Express", "Jefe de Operaciones", "Logistica", 8800, "Cochabamba", 10, 16, "Dirigiras la cadena de suministro y distribucion a nivel nacional.", R.drawable.bolivianexpress),
            Trabajos("Farmacia Boliviana", "Regente de Farmacia", "Salud", 7200, "Sucre", 8, 15, "Supervisaras dispensacion de medicamentos y gestion farmaceutica.", R.drawable.farmaciasbolivia),
            Trabajos("Universidad Catolica", "Decano de Facultad", "Educacion", 11000, "La Paz", 8, 14, "Dirigiras facultad universitaria y programas academicos.", R.drawable.ucb),
            Trabajos("Energia Renovable", "Project Manager", "Tecnologia", 9200, "Tarija", 9, 16, "Gestionaras proyectos de energia solar y eolica.", R.drawable.energiasrenovable),
            Trabajos("Bolsa Boliviana", "Analista de Mercados", "Atencion al Cliente", 8500, "Santa Cruz", 7, 12, "Analizaras tendencias bursatiles y asesoraras en inversiones.", R.drawable.bolsaboliviana),
            Trabajos("Clinica Alemana", "Oncologo", "Salud", 14500, "Cochabamba", 11, 18, "Especialista en diagnostico y tratamiento oncologico.", R.drawable.clinicaalemana),
            Trabajos("TecnoAndes", "Ingeniero de Software", "Tecnologia", 8100, "La Paz", 8, 13, "Desarrollaras aplicaciones empresariales y sistemas complejos.", R.drawable.tecnoandes),
            Trabajos("Hotel Camino Real", "Gerente General", "Turismo", 9800, "Santa Cruz", 10, 17, "Dirigiras todas las operaciones del hotel de 5 estrellas.", R.drawable.hotelcaminoreal),
            Trabajos("Minera San Cristobal", "Superintendente", "Produccion", 12500, "Potosi", 9, 16, "Supervisaras operaciones mineras a cielo abierto.", R.drawable.minerasancristobal),

            Trabajos("Banco Ganadero", "Ejecutivo Corporativo", "Atencion al Cliente", 8300, "Beni", 8, 15, "Gestionaras cartera de clientes empresariales del sector ganadero.", R.drawable.bancoganadero),
            Trabajos("Aeropuertos Bolivia", "Controlador Aereo", "Logistica", 9100, "La Paz", 12, 19, "Coordinaras trafico aereo y garantizaras seguridad en espacio aereo.", R.drawable.boa),
            Trabajos("Plasticos Bolivianos", "Jefe de Calidad", "Produccion", 7600, "Cochabamba", 9, 17, "Aseguraras estandares de calidad en produccion de productos plasticos.", R.drawable.plasticosbolivianos),
            Trabajos("Clinica San Juan", "Pediatra", "Salud", 9200, "Santa Cruz", 8, 14, "Atencion especializada a pacientes pediatricos y control de crecimiento.", R.drawable.clinicasanjuan),
            Trabajos("Colegio La Salle", "Director Academico", "Educacion", 8700, "La Paz", 7, 13, "Supervisaras plan curricular y desempeno docente en institucion.", R.drawable.lasalle),
            Trabajos("Distribuidora Mayorista", "Jefe de Logistica", "Logistica", 7900, "Cochabamba", 10, 17, "Coordinaras distribucion a nivel nacional de productos de consumo.", R.drawable.distribuidoramayorista),
            Trabajos("Agencia Publicitaria", "Director Creativo", "Marketing", 10500, "Santa Cruz", 9, 16, "Lideraras equipo creativo y desarrollaras campanas publicitarias.", R.drawable.agenciapublicitaria),
            Trabajos("Restaurante La Estancia", "Chef Ejecutivo", "Turismo", 6800, "La Paz", 11, 18, "Crearas menus gourmet y supervisaras operaciones de cocina.", R.drawable.restaurantelaestancia),
            Trabajos("Ingenieros Asociados", "Residente de Obra", "Construccion", 8400, "Tarija", 8, 15, "Supervisaras ejecucion de obras civiles y cumplimiento de especificaciones.", R.drawable.ingenierosasociados),
            Trabajos("Sistemas Integrados", "Analista de BI", "Tecnologia", 8900, "Oruro", 9, 16, "Desarrollaras dashboards y reportes para toma de decisiones.", R.drawable.sistemasintegrados),

            Trabajos("Farmacias Unidas", "Coordinador Regional", "Salud", 7700, "Pando", 8, 14, "Gestionaras operaciones de multiples farmacias en la region.", R.drawable.farmaciasunidas),
            Trabajos("Transporte Pesado", "Jefe de Flota", "Logistica", 8200, "Santa Cruz", 10, 17, "Supervisaras mantenimiento y operacion de vehiculos de carga pesada.", R.drawable.transportepesado),
            Trabajos("Metalurgica Boliviana", "Ingeniero de Procesos", "Produccion", 9300, "Potosi", 9, 16, "Optimizaras procesos metalurgicos y control de calidad.", R.drawable.metalurgicaboliviana),
            Trabajos("Instituto Tecnico", "Coordinador Academico", "Educacion", 7100, "Sucre", 7, 13, "Coordinaras programas tecnicos y practicas profesionales.", R.drawable.institutotecnico),
            Trabajos("Clinica del Sur", "Ginecologo", "Salud", 11800, "Tarija", 8, 15, "Especialista en salud femenina y procedimientos ginecologicos.", R.drawable.clinicadelsur),
            Trabajos("Alimentos Balanceados", "Jefe de Produccion", "Produccion", 8600, "Beni", 9, 17, "Dirigiras produccion de alimentos para ganado y mascotas.", R.drawable.alimentosbalanceados),
            Trabajos("Agencia Digital", "Especialista SEO", "Marketing", 7500, "Cochabamba", 8, 14, "Optimizaras posicionamiento web y estrategias de contenido.", R.drawable.agenciadigital),
            Trabajos("Hotel Presidente", "Recepcionista Senior", "Turismo", 4800, "La Paz", 10, 16, "Atencion a huespedes internacionales y gestion de reservas corporativas.", R.drawable.hotelpresidente),
            Trabajos("Construcciones Metalicas", "Ingeniero Estructural", "Construccion", 9700, "Santa Cruz", 8, 15, "Disenaras estructuras metalicas para edificios industriales.", R.drawable.construccionesmetalicas),
            Trabajos("Soluciones Cloud", "Arquitecto Cloud", "Tecnologia", 11200, "La Paz", 9, 16, "Disenaras infraestructuras cloud para empresas nacionales.", R.drawable.solucionescloud),

            Trabajos("Laboratorio Clinico", "Bioquimico Senior", "Salud", 8300, "Cochabamba", 8, 14, "Realizaras analisis complejos y supervisaras control de calidad.", R.drawable.laboratorioclinico),
            Trabajos("Distribuidora Farmaceutica", "Jefe de Almacen", "Logistica", 6900, "Santa Cruz", 9, 17, "Gestionaras inventario de medicamentos y productos medicos.", R.drawable.distribuidorafarmaceutica),
            Trabajos("Planta Embotelladora", "Supervisor de Turno", "Produccion", 7200, "Oruro", 12, 19, "Supervisaras operacion de linea de embotellado y envasado.", R.drawable.plantaembotelladora),
            Trabajos("Centro de Idiomas", "Coordinador Academico", "Educacion", 6400, "La Paz", 8, 15, "Coordinaras programas de ensenanza de idiomas para todas las edades.", R.drawable.centrodeidiomas),
            Trabajos("Consultorio Medico", "Medico General", "Salud", 7800, "Pando", 9, 16, "Atencion primaria a pacientes y manejo de casos ambulatorios.", R.drawable.consultoriomedico),
            Trabajos("Empresa de Seguridad", "Analista de Riesgos", "Atencion al Cliente", 8100, "Tarija", 8, 14, "Evaluaras riesgos operativos y disenaras planes de seguridad.", R.drawable.empresadeseguridad),
            Trabajos("Estudio de Diseno", "Disenador Senior", "Marketing", 7300, "Sucre", 9, 16, "Crearas identidad visual para marcas y campanas publicitarias.", R.drawable.estudiodediseno),
            Trabajos("Agencia de Viajes", "Gerente Comercial", "Turismo", 7900, "Cochabamba", 8, 15, "Desarrollaras estrategias comerciales para paquetes turisticos.", R.drawable.agenciadeviajes),
            Trabajos("Constructoras Unidas", "Ingeniero de Costos", "Construccion", 8800, "Santa Cruz", 9, 16, "Elaboraras presupuestos y controlaras costos de proyectos inmobiliarios.", R.drawable.constructorasnunidas),
            Trabajos("Desarrollo Movil", "Lider Tecnico", "Tecnologia", 10200, "La Paz", 8, 15, "Lideraras equipo de desarrollo de aplicaciones moviles nativas.", R.drawable.desarrollomovil)

        )
    }


}