package com.ValentinaAndrade.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var campoNombre: EditText? = null
    var campoMateria: EditText? = null
    var nota1: EditText? = null
    var nota2: EditText? = null
    var nota3: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre=findViewById(R.id.editTextNombre)
        campoMateria=findViewById(R.id.editTextMateria)
        nota1=findViewById(R.id.editText1)
        nota2=findViewById(R.id.editText2)
        nota3=findViewById(R.id.editText3)

        val miBoton:Button=findViewById(R.id.button)
        miBoton.setOnClickListener{onClick()}

    }

    private fun onClick() {
        val intent = Intent(this,InformationNotes::class.java)
        val miBundle:Bundle = Bundle()
        miBundle.putString("Nombre",campoNombre!!.text.toString())
        miBundle.putString("Materia",campoMateria!!.text.toString())
        miBundle.putString("Nota1",nota1!!.text.toString())
        miBundle.putString("Nota2",nota2!!.text.toString())
        miBundle.putString("Nota3",nota3!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
    }
}