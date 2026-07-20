# Registro de Empleados — Examen Final

Aplicación Android para gestionar el registro de empleados de una empresa.
Permite ingresar empleados mediante un formulario, listarlos y eliminarlos.

**Materia:** 232 - Introducción a la Programación para Dispositivos Móviles
**Profesor:** Lic. Diego Bonnin

## Tecnologías

- **Lenguaje:** Kotlin
- **UI:** Jetpack Compose (Material 3)
- **Mínimo SDK:** 24 · **Compilación:** SDK 34

## Estructura del proyecto

```
app/src/main/java/com/example/registroempleados/
├── MainActivity.kt              Activity principal. Monta la UI y sobrescribe
│                                onStart(), onStop() y onDestroy() con Log.i().
├── model/
│   └── Empleado.kt              Data class con los datos de cada empleado.
└── ui/
    ├── EmpleadosScreen.kt       Estado de la app, formulario de ingreso y
    │                            LazyColumn con la lista de empleados.
    ├── EmpleadoItem.kt          Ítem individual: nombre destacado + LazyRow
    │                            con los datos + botón Eliminar.
    └── theme/
        ├── Color.kt             Paletas de color para tema claro y oscuro.
        ├── Theme.kt             Definición del tema (light/dark).
        └── Type.kt              Tipografía.
```

## Cómo funciona

- **Formulario:** el primer elemento del `LazyColumn`. Recoge nombre, cargo,
  departamento, salario y fecha de contratación. El nombre es obligatorio.
- **Lista (`LazyColumn`):** debajo del formulario, muestra cada empleado en una
  `Card`.
- **Ítem:** el nombre se muestra destacado arriba; debajo un `LazyRow`
  presenta el resto de los datos en tarjetas desplazables; abajo, un botón
  "Eliminar" que quita ese empleado de la lista.
- **Tema claro/oscuro:** cambia automáticamente según el modo del sistema.
- **Ciclo de vida:** `MainActivity` registra en Logcat un mensaje al entrar en
  `onStart`, `onStop` y `onDestroy` (TAG = `MainActivity`).

## Cómo ejecutar la aplicación

1. Abrir el proyecto en **Android Studio** (File → Open → seleccionar esta carpeta).
2. Esperar a que Gradle sincronice y descargue las dependencias.
3. Seleccionar un emulador o conectar un dispositivo físico (API 24 o superior).
4. Presionar **Run ▶**.

### Cómo probar cada requisito

- **Registrar:** completar el formulario y presionar "Agregar empleado".
- **LazyRow:** deslizar horizontalmente los datos dentro de cada ítem.
- **Eliminar:** presionar el botón "Eliminar" de un ítem.
- **Tema oscuro:** activar el modo oscuro del sistema
  (Configuración → Pantalla → Tema oscuro en el emulador).
- **Ciclo de vida:** abrir **Logcat** y filtrar por `MainActivity`; al abrir,
  minimizar y cerrar la app se ven los mensajes onStart / onStop / onDestroy.
