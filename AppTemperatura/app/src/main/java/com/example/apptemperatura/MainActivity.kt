package com.example.apptemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtCelsius = findViewById<EditText>(R.id.edtCelsius)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnConverter.setOnClickListener {

            val celsius = edtCelsius.text.toString().toDoubleOrNull()

            if (celsius != null) {

                val fahrenheit = (celsius * 9 / 5) + 32

                txtResultado.text =
                    "Resultado: %.2f °F".format(fahrenheit)

            } else {

                txtResultado.text =
                    "Digite uma temperatura válida."
            }
        }
    }
}
