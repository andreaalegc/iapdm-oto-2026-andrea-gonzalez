package com.example.registroempleados

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.registroempleados.ui.EmpleadosScreen
import com.example.registroempleados.ui.theme.RegistroEmpleadosTheme

/**
 * Activity principal de la aplicación.
 *
 * Además de montar la interfaz de Compose, sobrescribe los métodos del ciclo
 * de vida onStart(), onStop() y onDestroy() para registrar un mensaje en el
 * Logcat (filtrar por el TAG "MainActivity" para verlos).
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroEmpleadosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmpleadosScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
