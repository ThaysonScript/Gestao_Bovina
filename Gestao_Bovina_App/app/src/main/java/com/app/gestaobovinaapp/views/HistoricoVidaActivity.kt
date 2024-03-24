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

    }
}