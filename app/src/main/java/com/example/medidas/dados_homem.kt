package com.example.medidas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dados_homem.*
import kotlin.math.ln
import kotlin.math.log10

class dados_homem : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_homem)

        val genero = intent.getStringExtra("genero")

        textView5.text = when(genero) {
            "H" -> "tríceps";
            "M" -> "subescapular";
            else -> "tríceps";
        }

        textView7.text = when(genero) {
            "H" -> "abdominal";
            "M" -> "coxa";
            else -> "abdominal";
        }

        val peso1 = when(genero) {
            "H" -> 1.17136;
            "M" -> 1.16650;
            else -> 1.17136;
        }

        val peso2 = when(genero) {
            "H" -> 0.06706;
            "M" -> 0.07063;
            else -> 0.06706;
        }

        button4.setOnClickListener {

            val valor1 = editText.text.toString().toDouble()
            val valor2 = editText.text.toString().toDouble()
            val valor3 = editText.text.toString().toDouble()

            val densidade: Double = peso1 - peso2 * log10(valor1 + valor2 + valor3)

            val intent = Intent(this, composicao::class.java)
            intent.putExtra("genero", genero)
            intent.putExtra("densidade", densidade)
            startActivity(intent)
        }
    }
}
