package com.example.concierto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), OnFragmentActionListener {
    val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binfo= findViewById<Button>(R.id.button)
        val bmapa= findViewById<Button>(R.id.button2)
        val bentradas= findViewById<Button>(R.id.button3)
        binfo.setOnClickListener(){
            cargarFragmento(BotonInfo())
        }
        bmapa.setOnClickListener(){
            cargarFragmento(MapaFragment())
        }
        bentradas.setOnClickListener(){
            cargarFragmento(EntradasFragment())
        }

    }
    fun cargarFragmento(mifragment:Fragment){
        try {

            val fragmentTransaction= fragmentManager.beginTransaction()
            Toast.makeText(applicationContext, "Hola", Toast.LENGTH_LONG).show()
            fragmentTransaction.replace(R.id.fragmentContainerView2, mifragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }catch (e:IllegalStateException){

        }
    }

    override fun onClickFragmentButton(datos: Bundle?) {
        findViewById<TextView>(R.id.textView).setText(datos?.getString("nombre"))
    }
}