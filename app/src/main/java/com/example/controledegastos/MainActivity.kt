package com.example.controledegastos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        val id = view?.id

        if (id == R.id.buttonCalcular) {
            calcular()
        }

    }

    private fun calcular() {
        if (validarCampo()) {

            val distancia = editDistancia.text.toString().toFloat()
            val preco = editPreco.text.toString().toFloat()
            val autonomia = editAutonomia.text.toString().toFloat()

            val valorFinalConsumo = (distancia * preco) / autonomia

            resultado.text = "R$ ${"%.2f".format(valorFinalConsumo)}"
        }

        Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()


    }

    private fun validarCampo(): Boolean {
        return (editDistancia.text.toString() != "" && editPreco.text.toString() != "" && editAutonomia.text.toString() != "")


    }


}