package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.autofill.AutofillId
import com.example.logonrm.imc.extensions.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    fun setaImagem(resourceId: Int){
        ivStatusIMC.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.abaixo))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if(intent.extras != null){
            val peso = intent.getStringExtra( "PESO").toDouble()
            val altura = intent.getStringExtra( "ALTURA").toDouble()

            val imc = peso / (altura * altura)

            tvIMC.text = imc.format(1)

            if ( imc < 18.5 ){
                tvStatusIMC.text = "Magrelo"
                setaImagem(R.drawable.magreza
            }else if ( imc < 24.9){
                tvStatusIMC.text = "Abaixo do peso"
                setaImagem(R.drawable.abaixo)
            }else if ( imc < 29.9 ){
                tvStatusIMC.text = "Peso Ideal"
                setaImagem(R.drawable.ideal)
            }else if ( imc < 34.9 ) {
                tvStatusIMC.text = "Sobre peso"
                setaImagem(R.drawable.sobre)
            }else if ( imc < 39.9 ) {
                tvStatusIMC.text = "Acima do peso"
                setaImagem(R.drawable.obesidade)
            }

        }
    }
}
