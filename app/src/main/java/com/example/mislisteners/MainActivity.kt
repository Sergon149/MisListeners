package com.example.mislisteners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.mislisteners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var numeroDeHolas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.bDecirHola.setOnClickListener{
            Toast.makeText(this,"HOLA1", Toast.LENGTH_LONG).show()
            binding.tvHola.text = "Hola ${numeroDeHolas++}"
        }

        binding.etUno.setOnFocusChangeListener{view, hasFocus ->
            if (hasFocus){
                println("Soy el etUno y tengo el focus")
            }else{
                println("Soy el etUno y no tengo el focus")
            }
        }

        binding.etDos.setOnFocusChangeListener{view, hasFocus ->
            if (hasFocus){
                println("Soy el etDos y tengo el focus")
            }else{
                println("Soy el etDos y no tengo el focus")
            }
        }
        binding.etDos.doOnTextChanged { text, start, before, count ->
            if (text.contentEquals("Hola")){
                Toast.makeText(this, "Hola a ti bb", Toast.LENGTH_LONG).show()
            }
        }
    }
}