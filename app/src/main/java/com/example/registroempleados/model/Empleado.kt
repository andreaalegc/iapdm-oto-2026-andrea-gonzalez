package com.example.registroempleados.model

/**
 * Representa a un empleado registrado en la aplicación.
 *
 * @param id Identificador único, usado como clave estable en la lista.
 */
data class Empleado(
    val id: Int,
    val nombre: String,
    val cargo: String,
    val departamento: String,
    val salario: String,
    val fechaContratacion: String
)
