package com.studio.s02e01kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val nViewHolder = ViewHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="Conversor de Moedas"
        this.nViewHolder.editValor = edit_valor
        this.nViewHolder.textDolar = text_dolar
        this.nViewHolder.textEuro = text_euro
        this.nViewHolder.buttonCalcular = button_calcular

        buttonCalcular?.setOnClickListener(this)

        this.clearValues()
    }

    private fun clearValues() {
        textDolar?.text = ""
        textEuro?.text = ""
    }

    private companion object ViewHolder {
        var editValor: EditText? = null
        var textDolar: TextView? = null
        var textEuro: TextView? = null
        var buttonCalcular: Button? = null
    }

    override fun onClick(v: View) {
        if (v.id == button_calcular.id){
            var valor: String = editValor?.text.toString()
            if ("".equals(valor)){
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show()
            }else{
                val real: Double = valor.toDouble()

                textDolar?.text = String.format("%.2f",real/4)
                textEuro?.text = String.format("%.2f",real/5)
            }
        }
    }
}
