package com.app.gestaobovinaapp.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.database.BancoDados
import com.app.gestaobovinaapp.databinding.ActivityCadastrarAnimaisBinding
import com.app.gestaobovinaapp.factory.BovinoFactoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CadastrarAnimaisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarAnimaisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastrarAnimaisBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        binding.botaoSalvar.setOnClickListener() {
            val nomeBovino = binding.idNomeBovino.text.toString()
            val dataCompra = binding.idDataCompra.text.toString()
            val precoCompra = binding.idPrecoCompra.text.toString().toDouble()
            val pesoAtual = binding.idPesoAtual.text.toString().toDouble()

            val db = BancoDados(this)

            val factory = BovinoFactoryImpl(db)

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    factory.adicionarBovino(nomeBovino, dataCompra, precoCompra, pesoAtual)
                    runOnUiThread {
                        Toast.makeText(this@CadastrarAnimaisActivity, "Bovino adicionado com sucesso", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    runOnUiThread {
                        Toast.makeText(this@CadastrarAnimaisActivity, "Erro ao adicionar bovino: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}