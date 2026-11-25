package br.edu.fatecpg.calculadoraandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edt1 = findViewById<EditText>(R.id.edt_val1)
        val edt2 = findViewById<EditText>(R.id.edt_val2)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val txvResult = findViewById<TextView>(R.id.txv_resultado)

        btnCalcular.setOnClickListener{
            val valor1 = edt1.text.toString().toDouble()
            val valor2 = edt2.text.toString().toDouble()
            val soma =  valor1 + valor2

            txvResult.setText("Resultado da soma: $soma")
            edt1.text.clear()
            edt2.text.clear()
            Toast.makeText(this,"Soma realizada",Toast.LENGTH_SHORT).show()
        }
    }
}