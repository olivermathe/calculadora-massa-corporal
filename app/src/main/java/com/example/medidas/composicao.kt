package com.example.medidas

import android.app.Activity
import android.content.Intent
import android.icu.text.RelativeDateTimeFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_composicao.*

class composicao : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composicao)

        val genero = intent.getStringExtra("genero")
        val densidade = intent.getDoubleExtra("densidade", .0);
        val percGordura = ((4.95 / densidade) - 4.50) * 100

        textView13.text = when(genero) {
            "H" -> this.getClassificacaoHomem(percGordura);
            "M" -> this.getClassificacaoMulher(percGordura)
            else -> this.getClassificacaoHomem(percGordura)
        }

        button6.setOnClickListener {
            val intent = Intent(this, peso::class.java)
            intent.putExtra("percGordura", percGordura)
            intent.putExtra("genero", genero)
            startActivity(intent)
        }
    }

    fun getClassificacaoHomem(percGordura: Double): String {

        if (percGordura <= 4) {
            return "MAGRO"
        }

        if (percGordura <= 8) {
            return "ABAIXO DA MÉDIA"
        }

        if (percGordura <= 16) {
            return "NA MÉDIA"
        }

        if (percGordura <= 24) {
            return "ACIMA DA MÉDIA"
        }

        return "OBESO"

    }

    fun getClassificacaoMulher(percGordura: Double): String {

        if (percGordura <= 8) {
            return "MAGRO"
        }

        if (percGordura <= 14) {
            return "ABAIXO DA MÉDIA"
        }

        if (percGordura <= 22) {
            return "NA MÉDIA"
        }

        if (percGordura <= 29) {
            return "ACIMA DA MÉDIA"
        }

        return "OBESO"

    }

}
