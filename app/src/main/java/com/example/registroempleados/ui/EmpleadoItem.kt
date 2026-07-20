package com.example.registroempleados.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.registroempleados.model.Empleado

/**
 * Ítem individual de la lista de empleados.
 *
 * Estructura pedida por el examen:
 *  - Nombre destacado en la parte superior.
 *  - Un LazyRow con el resto de los datos (cargo, departamento, salario, fecha).
 *  - Un botón "Eliminar" en la parte inferior.
 */
@Composable
fun EmpleadoItem(
    empleado: Empleado,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Nombre destacado (parte superior)
            Text(
                text = empleado.nombre,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            // LazyRow con los demás datos del empleado
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item { DatoChip(etiqueta = "Cargo", valor = empleado.cargo) }
                item { DatoChip(etiqueta = "Departamento", valor = empleado.departamento) }
                item { DatoChip(etiqueta = "Salario", valor = empleado.salario) }
                item { DatoChip(etiqueta = "Contratación", valor = empleado.fechaContratacion) }
            }

            // Botón de eliminación (parte inferior)
            Button(
                onClick = onEliminar,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                ),
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
                Spacer(Modifier.width(4.dp))
                Text("Eliminar")
            }
        }
    }
}

/**
 * Pequeña "tarjeta-dato" reutilizable que se muestra dentro del LazyRow.
 */
@Composable
private fun DatoChip(etiqueta: String, valor: String) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = MaterialTheme.shapes.small
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
            Text(text = etiqueta, style = MaterialTheme.typography.labelSmall)
            Text(
                text = valor.ifBlank { "—" },
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
