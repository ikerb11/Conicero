package com.example.concierto

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EntradasFragment : Fragment() {
    private var  listener:OnFragmentActionListener?=null
    private var  b1: Button?=null
    private lateinit var entrada: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionListener){
            listener=context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_entradas, container, false)
        entrada = vista.findViewById(R.id.entrada)
        b1= vista.findViewById(R.id.b1)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b1?.setOnClickListener{
            var datos:Bundle?=Bundle()
            datos?.putString("nombre", entrada.text.toString())
            listener?.onClickFragmentButton(datos)
        }
    }


}