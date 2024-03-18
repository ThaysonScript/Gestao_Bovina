package com.app.gestaobovinaapp.views

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.database.BancoDados
import com.app.gestaobovinaapp.databinding.ActivityHistoricoVidaBinding
import com.app.gestaobovinaapp.factory.BovinoFactoryImpl
import com.app.gestaobovinaapp.factory.VacinaFactoryImpl

class HistoricoVidaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoricoVidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoVidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val db = BancoDados(this)
            val bovinoFactory = BovinoFactoryImpl(db)
            val dadosBovinos = bovinoFactory.obterTodosBovinos()


            val dadosFormatados = dadosBovinos.joinToString(separator = "\n")
            binding.textViewDadosBovinos.text = "Dados dos Bovinos:\n\n$dadosFormatados"
        } catch (e: Exception) {
            Log.e(TAG, "Exception in HistoricoVidaActivity", e)
        }
    }

    companion object {
        private const val TAG = "HistoricoVidaActivity"
    }
}