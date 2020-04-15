package com.example.medidas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_peso.*

class peso : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso)

        val genero = intent.getStringExtra("genero")
        val percGordura = intent.getDoubleExtra("percGordura", .0)

        button7.setOnClickListener {

            val peso: Double = editText4.text.toString().toDouble()

            val intent = Intent(this, ultima::class.java)
            intent.putExtra("peso", peso)
            intent.putExtra("percGordura", percGordura)
            intent.putExtra("genero", genero)
            startActivity(intent)
        }
    }
}
