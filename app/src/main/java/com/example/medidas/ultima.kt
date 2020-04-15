package com.example.medidas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ultima.*

class ultima : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ultima)

        val peso = intent.getDoubleExtra("peso", .0)
        val genero = intent.getStringExtra("genero")
        val percGordura = intent.getDoubleExtra("percGordura", .0)

        val pesoGordo = (percGordura/100) * peso
        val massaMagra = peso - pesoGordo
        val pesoIdeal = when(genero) {
            "H" -> massaMagra / 0.85;
            "M" -> massaMagra / 0.75;
            else -> massaMagra / 0.85;
        }
        val pesoExcesso = peso - pesoIdeal

        println(peso)
        println(genero)
        println(percGordura)
        println(pesoGordo)
        println(massaMagra)
        println(pesoIdeal)
        println(pesoExcesso)

        textView9.text = "peso gordo " + "%.2f".format(pesoGordo) + "kg"
        textView10.text = "massa magra " + "%.2f".format(massaMagra) + "kg"
        textView11.text = "pesso ideal " + "%.2f".format(pesoIdeal) + "kg"
        textView12.text = "pesso excesso " + "%.2f".format(pesoExcesso) + "kg"

        button5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
