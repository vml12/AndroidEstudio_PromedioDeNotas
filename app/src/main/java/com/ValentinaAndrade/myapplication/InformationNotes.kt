package com.ValentinaAndrade.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class InformationNotes : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_notes)

        val campoNombre=findViewById<TextView>(R.id.textNombre)
        val campoMateria=findViewById<TextView>(R.id.textMateria)
        val campoNota1=findViewById<TextView>(R.id.textNota1)
        val campoNota2=findViewById<TextView>(R.id.textNota2)
        val campoNota3=findViewById<TextView>(R.id.textNota3)
        val campoPromedio=findViewById<TextView>(R.id.textPromedio)
        val campoEstado=findViewById<TextView>(R.id.textEstado)

        var miBundle: Bundle? = this.intent.extras

        if(miBundle != null){
            var nota1 = miBundle.getString("Nota1")!!.toDouble()
            var nota2 = miBundle.getString("Nota2")!!.toDouble()
            var nota3 = miBundle.getString("Nota3")!!.toDouble()
            if(nota1 < 0 || nota2 < 0 || nota3 < 0 || nota1 > 5 || nota2 > 5 || nota3 > 5){
                finish()
            } else {
                var promedio = (nota1+nota2+nota3)/3

                campoNombre.text="Nombre: ${miBundle.getString("Nombre")}"
                campoMateria.text="Materia: ${miBundle.getString("Materia")}"
                campoNota1.text="Nota 1: ${nota1}"
                campoNota2.text="Nota 2: ${nota2}"
                campoNota3.text="Nota 3: ${nota3}"
                campoPromedio.text="Promedio: ${promedio}"
                if(promedio>=3.5){
                    campoEstado.text="Estado: Aprobado"
                    campoEstado.setTextColor(ContextCompat.getColor(this, R.color.Ganar))
                } else {
                    campoEstado.text="Estado: Reprobado"
                    campoEstado.setTextColor(ContextCompat.getColor(this, R.color.Perder))
                }
            }
            val botonSalir:Button=findViewById(R.id.btnSalir)
            botonSalir.setOnClickListener{onClick()}
        }
    }

    private fun onClick() {
        finish()
    }
}