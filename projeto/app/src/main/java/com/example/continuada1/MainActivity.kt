package com.example.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculaSalarioFamilia(componente: View) {

        val salario: Double = etSalario.text.toString().toDouble()
        val qtdFilhos: Double = etQtdFilhos.text.toString().toDouble()
        val valorSalarioFamilia: Double = (qtdFilhos * 48.62)

        if (etNome.text.length < 4) {
            Toast.makeText(this, "O nome deve ter no mínimo 4 caracteres", Toast.LENGTH_LONG).show()
        } else if (salario < 1045.00) {
            Toast.makeText(this, "O sálario mínimo deve ser de: 1045.00R$", Toast.LENGTH_LONG)
                .show()
        } else if (qtdFilhos < 1) {
            Toast.makeText(this, "Deve haver no mínimo 1 filho", Toast.LENGTH_LONG).show()
        } else {
            if (salario > 1425.56) {
                tvResultado.setTextColor(Color.parseColor("#FF0000"))
                tvResultado.text = String.format(
                    "Olá %s, o seu salário é %.2f, maior do que o permitido, " +
                            "portanto não tem direito ao salário família", etNome.text, salario
                )
            } else if (qtdFilhos < 2) {
                tvResultado.setTextColor(Color.parseColor("#FFA500"))
                tvResultado.text = String.format(
                    "Olá %s, o valor do seu salário família é de: 48.62$, valor mínimo",
                    etNome.text
                )
            } else {
                tvResultado.setTextColor(Color.parseColor("#0000FF"))
                tvResultado.text = String.format(
                    "Olá %s, o valor do seu salário família é de %.2f", etNome.text, valorSalarioFamilia
                )
            }
        }
    }
}
