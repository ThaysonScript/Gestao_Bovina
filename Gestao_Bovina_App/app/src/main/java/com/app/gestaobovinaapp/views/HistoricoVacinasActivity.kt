package com.app.gestaobovinaapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.gestaobovinaapp.database.BancoDados
import com.app.gestaobovinaapp.databinding.ActivityHistoricoVacinasBinding

class HistoricoVacinasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoricoVacinasBinding
    private lateinit var db: BancoDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoVacinasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = BancoDados(this)

        // Configurar RecyclerView
        binding.recyclerViewVacinas.layoutManager = LinearLayoutManager(this)
    }
}