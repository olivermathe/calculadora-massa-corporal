package com.example.medidas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_genero.*

class tela_genero : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_genero)
        button2.setOnClickListener {
            val intent = Intent(this, dados_homem::class.java)
            intent.putExtra("genero", "H")
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, dados_homem::class.java)
            intent.putExtra("genero", "M")
            startActivity(intent)
        }
    }
}
