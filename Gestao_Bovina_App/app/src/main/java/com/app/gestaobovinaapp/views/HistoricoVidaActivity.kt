package com.app.gestaobovinaapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.databinding.ActivityHistoricoVidaBinding

class HistoricoVidaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoricoVidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoVidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}