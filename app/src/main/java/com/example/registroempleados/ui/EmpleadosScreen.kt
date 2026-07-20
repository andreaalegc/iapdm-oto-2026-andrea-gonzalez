package com.example.registroempleados.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.registroempleados.model.Empleado

/**
 * Pantalla principal: contiene el estado de la app (lista de empleados),
 * el formulario de ingreso y la lista vertical (LazyColumn).
 *
 * El formulario se agrega como primer `item` del LazyColumn para que todo
 * el contenido se desplace en conjunto sin conflictos de scroll.
 */
@Composable
fun EmpleadosScreen(modifier: Modifier = Modifier) {
    val empleados = remember { mutableStateListOf<Empleado>() }
    var siguienteId by remember { mutableIntStateOf(0) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Formulario de ingreso (arriba)
        item {
            FormularioEmpleado(
                onAgregar = { nombre, cargo, departamento, salario, fecha ->
                    empleados.add(
                        Empleado(
                            id = siguienteId,
                            nombre = nombre,
                            cargo = cargo,
                            departamento = departamento,
                            salario = salario,
                            fechaContratacion = fecha
                        )
                    )
                    siguienteId++
                }
            )
        }

        // Lista de empleados (debajo del formulario)
        items(items = empleados, key = { it.id }) { empleado ->
            EmpleadoItem(
                empleado = empleado,
                onEliminar = { empleados.remove(empleado) }
            )
        }
    }
}

/**
 * Formulario con los campos del empleado. Mantiene su propio estado local
 * y notifica al padre mediante [onAgregar] cuando se confirma el registro.
 */
@Composable
fun FormularioEmpleado(
    onAgregar: (
        nombre: String,
        cargo: String,
        departamento: String,
        salario: String,
        fecha: String
    ) -> Unit,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var cargo by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }
    var salario by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Registro de Empleados",
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cargo,
            onValueChange = { cargo = it },
            label = { Text("Cargo") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = departamento,
            onValueChange = { departamento = it },
            label = { Text("Departamento") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = salario,
            onValueChange = { salario = it },
            label = { Text("Salario") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha de contratación") },
            placeholder = { Text("dd/mm/aaaa") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                onAgregar(nombre, cargo, departamento, salario, fecha)
                // Limpiar el formulario tras agregar
                nombre = ""
                cargo = ""
                departamento = ""
                salario = ""
                fecha = ""
            },
            enabled = nombre.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar empleado")
        }
    }
}
