package com.rafaelo.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var btnCalcular: Button
    lateinit var textPeso: TextInputEditText
    lateinit var textAltura: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btn_calcular)
        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)

        btnCalcular.setOnClickListener {
            //val toast: Toast = Toast.makeText(this, "botao Funcionando", Toast.LENGTH_SHORT)
            //toast.show()

            if (textPeso.text.isNullOrBlank()) {
                val toast: Toast = Toast.makeText(this, "insira seu peso", Toast.LENGTH_SHORT)
                toast.show()
            } else if (textAltura.text.isNullOrBlank()) {
                val toast: Toast = Toast.makeText(this, "insira sua altura", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                var peso: Double = textPeso.text.toString().toDouble()
                var altura: Double = textAltura.text.toString().toDouble()
                var resultado: Double = calcularIMC(peso, altura)

                val intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("resultado", resultado)
                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)

                startActivity(intent)
            }


        }
    }

    fun calcularIMC(peso: Double, altura: Double): Double {
        //peso / altura²
        return (peso / (altura * altura))
    }
}