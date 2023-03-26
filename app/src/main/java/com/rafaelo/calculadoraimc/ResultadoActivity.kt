package com.rafaelo.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var tvPeso: TextView
    private lateinit var tvAltura: TextView
    private lateinit var tvResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        tvPeso = findViewById(R.id.tv_peso)
        tvAltura = findViewById(R.id.tv_altura)
        tvResultado = findViewById(R.id.tv_resultado)

        val bundle = intent.extras

        if(bundle != null){
            val resultado = bundle.getDouble("resultado")
            var resultadoCalculo: String = imc(resultado)
            var pesoInformado: String = bundle.getDouble("peso").toString()
            var alturaInformada: String = bundle.getDouble("altura").toString()
            tvPeso.text = "Peso informado $pesoInformado KG"
            tvAltura.text = "Altura informada $alturaInformada M"
            tvResultado.text = resultadoCalculo
        }




    }

    private fun imc(resultado: Double): String{
        return if(resultado < 18.5){
            "Abaixo do peso"
        }else if(resultado in 18.5..24.9){
            "Peso normal"
        }else if(resultado in 25.0..29.9){
            "Acima do peso (sobrepeso)"
        }else if(resultado in 30.0..34.9){
            "Obesidade I"
        }else if(resultado in 35.0..39.9){
            "Obesidade II"
        }else{
            "Obesidade III"
        }
    }
}