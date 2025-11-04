# EmpleaBol

*EmpleaBol* es una aplicación móvil desarrollada en *Android Studio (Kotlin)* que permite buscar ofertas laborales en los nueve departamentos de Bolivia.  
El usuario puede registrarse, iniciar sesión, buscar empleos por área o ciudad, postular a trabajos y gestionar sus postulaciones desde su perfil.

---

## Requisitos previos
Antes de compilar el proyecto, asegúrate de tener instalado:

- *Android Studio*
- *Conexión a Internet* para sincronizar dependencias de Gradle

---

## Pasos para compilar y ejecutar el proyecto

### 1️⃣ Clonar el repositorio
1. Únete al repositorio en GitHub.  
2. Abre *Android Studio*.  
3. Ve a *File → New → Clone repository.  
4. Pega el enlace del proyecto y presiona *Clone*.  
5. El proyecto se clonará y quedará en tu espacio de trabajo.  
6. Busca la carpeta con el nombre *GGLeito* y ábrela.  
7. Espera a que *Gradle sincronice las dependencias automáticamente*.

---

### 2️⃣ Configurar librerías
1. En la esquina superior izquierda, cambia la vista de *“Android”* a *“Project”*.  
2. Descarga el archivo **google-services.json**, que fue adjuntado en el google Drive de este proyecto. 
3. Colócalo dentro de la carpeta:  
/app
4. Presiona el botón *“Sync Now”* para aplicar los cambios de Gradle.  
5. Verifica que en tu archivo build.gradle (Module: app) tengas la siguiente línea:
``gradle
apply plugin: 'com.google.gms.google-services'

### 3️⃣ Ejecutar la aplicación
1. Conecta un dispositivo Android físico o usa un emulador (AVD) desde Android Studio.
2. Presiona el botón Run ▶.
3. Espera a que la app se compile e instale automáticamente.
