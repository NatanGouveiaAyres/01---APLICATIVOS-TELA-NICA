package com.example.leideohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTensao = findViewById<EditText>(R.id.edtTensao)
        val edtResistencia = findViewById<EditText>(R.id.edtResistencia)
        val edtCorrente = findViewById<EditText>(R.id.edtCorrente)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val tensao = edtTensao.text.toString().toDoubleOrNull()
            val resistencia = edtResistencia.text.toString().toDoubleOrNull()
            val corrente = edtCorrente.text.toString().toDoubleOrNull()

            val quantidadePreenchida =
                listOf(tensao, resistencia, corrente).count { it != null }

            // Nenhum ou apenas um campo preenchido
            if (quantidadePreenchida < 2) {

                Toast.makeText(
                    this,
                    "Preencha pelo menos dois campos.",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Tensão + Resistência = calcular Corrente
            if (tensao != null && resistencia != null && corrente == null) {

                if (resistencia == 0.0) {
                    Toast.makeText(
                        this,
                        "A resistência não pode ser zero.",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@setOnClickListener
                }

                val resultado = tensao / resistencia

                txtResultado.text =
                    "Corrente: %.2f A".format(resultado)
            }

            // Tensão + Corrente = calcular Resistência
            else if (tensao != null && corrente != null && resistencia == null) {

                if (corrente == 0.0) {
                    Toast.makeText(
                        this,
                        "A corrente não pode ser zero.",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@setOnClickListener
                }

                val resultado = tensao / corrente

                txtResultado.text =
                    "Resistência: %.2f Ω".format(resultado)
            }

            // Resistência + Corrente = calcular Tensão
            else if (resistencia != null && corrente != null && tensao == null) {

                val resultado = resistencia * corrente

                txtResultado.text =
                    "Tensão: %.2f V".format(resultado)
            }

            // Os três campos foram preenchidos
            else {

                Toast.makeText(
                    this,
                    "Preencha somente dois campos.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
