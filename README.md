# 🛍️ Shop App - ORT-YA-TP3-CHALLENGE2

# Integrantes

- Liscovsky, Iván
- Serrudo Arteaga, Carlos
- Taddeo, Leandro Christian
- Velasquez Garcia, Gustavo

---

## 📋 Descripción General

Shop App es una aplicación móvil de comercio electrónico desarrollada en **Kotlin** con **Jetpack Compose**. La aplicación permite a los usuarios navegar por productos, agregarlos a favoritos, gestionar su perfil y comunicarse con el equipo de soporte a través de un chat integrado.

---

## 🎯 Características Principales

### 🏠 Pantallas Disponibles

1. **MainLayoutScreen** - Pantalla principal con información general
2. **ShopListScreen** - Catálogo de productos disponibles
3. **LeatherBootsScreen** - Detalles detallados del producto (botas de cuero)
4. **FavouritesScreen** - Gestor de productos favoritos
5. **ProfileScreen** - Gestión del perfil de usuario
6. **SettingsScreen** - Configuración de la aplicación

### 🔧 Componentes y Funcionalidades

- **📱 Navegación con Drawer** - Menú lateral para navegar entre pantallas
- **🧭 Bottom Navigation Bar** - Navegación rápida a secciones principales
- **❤️ Sistema de Favoritos** - Agregar/eliminar productos de la lista de favoritos
- **💬 Chat con Manager** - Diálogo para comunicación con soporte
- **📦 Carrito de Compras** - Diálogo con lista de órdenes
- **🎨 Interfaz Material Design 3** - Diseño moderno y consistente

---

## 🛠️ Stack Tecnológico

### Dependencias Principales

| Componente | Versión | Propósito |
|-----------|---------|----------|
| **Android Gradle Plugin** | 8.13.0 | Build system |
| **Kotlin** | 2.0.21 | Lenguaje principal |
| **Jetpack Compose** | 2024.09.00 | UI framework |
| **Material 3** | 1.3.2 | Design system |
| **Navigation Compose** | 2.9.4 | Gestión de navegación |
| **AndroidX Core KTX** | 1.17.0 | Extensiones Kotlin |
| **Activity Compose** | 1.11.0 | Integración con Activities |

### Versiones Objetivo

- **compileSdk:** 36
- **minSdk:** 26
- **targetSdk:** 36
- **Java/Kotlin:** JVM 11

---

## 📁 Estructura del Proyecto

```
Challenge2/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/ort/challenge2/
│   │       │   ├── MainActivity.kt                 # Actividad principal
│   │       │   └── ui/
│   │       │       ├── components/                 # Componentes reutilizables
│   │       │       │   ├── TopAppBar.kt
│   │       │       │   ├── BottomNavigationBar.kt
│   │       │       │   ├── ProductCard.kt
│   │       │       │   ├── ChatManagerDialog.kt
│   │       │       │   ├── OrderListDialog.kt
│   │       │       │   ├── AddedToFavouritesDialog.kt
│   │       │       │   ├── AppDrawer.kt
│   │       │       │   ├── Buttons.kt
│   │       │       │   ├── SettingsComponents.kt
│   │       │       │   ├── ProfileComponents.kt
│   │       │       │   ├── ProductInputs.kt
│   │       │       │   └── OrderComponents.kt
│   │       │       ├── screens/                    # Pantallas principales
│   │       │       │   ├── MainLayoutScreen.kt
│   │       │       │   ├── ShopListScreen.kt
│   │       │       │   ├── LeatherBootsScreen.kt
│   │       │       │   ├── FavouritesScreen.kt
│   │       │       │   ├── ProfileScreen.kt
│   │       │       │   └── SettingsScreen.kt
│   │       │       ├── navigation/                 # Sistema de navegación
│   │       │       │   ├── NavGraph.kt
│   │       │       │   ├── NavigationRoutes.kt
│   │       │       │   └── AppNavigationState.kt
│   │       │       ├── manager/                    # Gestores de estado
│   │       │       │   └── FavoritesManager.kt
│   │       │       ├── model/                      # Modelos de datos
│   │       │       │   └── Product.kt
│   │       │       └── theme/                      # Tema y estilos
│   │       │           ├── Theme.kt
│   │       │           ├── Color.kt
│   │       │           ├── Type.kt
│   │       │           ├── Shape.kt
│   │       │           └── Font.kt
│   │       └── res/
│   │           ├── values/                        # Recursos de string, colores, temas
│   │           │   ├── strings.xml
│   │           │   ├── colors.xml
│   │           │   ├── themes.xml
│   │           │   └── product_strings.xml
│   │           ├── drawable/                      # Assets e imágenes
│   │           ├── mipmap-*/                      # Iconos de app
│   │           └── xml/                           # Configuración XML
│   └── build.gradle.kts                           # Configuración del módulo
├── gradle/
│   ├── libs.versions.toml                         # Versiones de dependencias
│   └── wrapper/
├── build.gradle.kts                               # Configuración raíz
├── settings.gradle.kts                            # Configuración de módulos
└── README.md                                      # Este archivo
```

---

## 📦 Modelos de Datos

### Product
```kotlin
data class Product(
    val id: Int,
    val title: String,
    val price: String,
    val description: String,
    val imageResId: Int
)
```

---

## 🔄 Gestión de Estado

### FavoritesManager
Object singleton que gestiona:
- Lista de productos favoritos
- Función `getSampleProducts(context: Context)` - Obtiene productos de ejemplo con strings desde recursos
- Métodos CRUD para favoritos:
  - `addToFavorites(product)`
  - `removeFromFavorites(product)`
  - `isInFavorites(product)`

---

## 🧭 Sistema de Navegación

### Rutas Disponibles
- `home` - Pantalla principal
- `shop` - Listado de tienda
- `leather_boots_detail` - Detalle del producto
- `favorites` - Productos favoritos
- `profile` - Perfil del usuario
- `settings` - Configuración

### Características
- Navegación con NavigationCompose
- Drawer menu para acceso directo
- Bottom navigation bar
- Transiciones suaves entre pantallas

---

## 🎨 Tema y Estilos

### Material Design 3
- Colores personalizados en `colors.xml`
- Tipografía personalizada en `Type.kt`
- Formas redondeadas configurables en `Shape.kt`
- Fuentes personalizadas en `Font.kt`

### Recursos Modularizados
Todos los textos de la aplicación se encuentran centralizados en `strings.xml`:
- TopBar
- Productos
- Botones
- Navegación
- Diálogos
- Pantallas de perfil y configuración

---

## 💬 Diálogos y Componentes Especiales

### ChatWithManagerDialog
- Comunicación con soporte
- Strings modularizadas desde recursos
- Campo de entrada para mensajes

### OrderListDialog
- Muestra la lista de productos a comprar
- Componentes reutilizables para órdenes

### AddedToFavouritesDialog
- Confirmación al agregar a favoritos
- Opciones de descartar/aceptar

---

## 🚀 Cómo Compilar y Ejecutar

### Prerrequisitos
- Android Studio Hedgehog o superior
- JDK 11
- Android SDK 36

### Pasos
1. Clonar el repositorio
2. Abrir el proyecto en Android Studio
3. Esperar a que Gradle sincronice las dependencias
4. Conectar un dispositivo Android o usar un emulador
5. Presionar `Shift + F10` para ejecutar la aplicación

### Compilar APK
```bash
./gradlew assembleDebug
```

---

## 📝 Convenciones de Código

- **Lenguaje:** Kotlin
- **UI Framework:** Jetpack Compose
- **Arquitectura:** MVVM (con Compose)
- **Nomenclatura:** camelCase para variables y funciones
- **Strings:** Todos centralizados en recursos (no hardcodeados)
- **Comentarios:** En español/inglés según contexto

---

## 🎓 Información del Estudiante

- **Alumno:** Iván L.
- **Institución:** ORT
- **Materia:** YA-TP3-CHALLENGE2

---

## 📞 Contacto y Soporte

Para consultas o problemas con la aplicación, utiliza la función "Chat with Manager" disponible en la app.

---

## 📄 Licencia

Este proyecto fue desarrollado como parte de un challenge educativo en ORT.

---

**Última actualización:** Noviembre 2025

