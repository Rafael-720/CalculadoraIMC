package com.rafaelo.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            //val toast: Toast = Toast.makeText(this, "botao Funcionando", Toast.LENGTH_SHORT)
            //toast.show()
        }
    }
}