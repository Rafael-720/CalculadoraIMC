package com.rafaelo.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    lateinit var tvPeso: TextView
    lateinit var tvAltura: TextView
    lateinit var tvResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        tvPeso = findViewById(R.id.tvPeso)
        tvAltura = findViewById(R.id.tvAltura)
        tvResultado = findViewById(R.id.tvResultado)

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

    fun imc(resultado: Double): String{
        if(resultado < 18.5){
            return "Abaixo do peso"
        }else if(resultado >= 18.5 && resultado <= 24.9){
            return "Peso normal"
        }else if(resultado >= 25 && resultado <= 29.9){
            return "Acima do peso (sobrepeso)"
        }else if(resultado >= 30 && resultado <= 34.9){
            return "Obesidade I"
        }else if(resultado >= 35 && resultado <= 39.9){
            return "Obesidade II"
        }else{
            return "Obesidade III"
        }
    }
}