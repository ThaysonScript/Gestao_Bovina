package com.app.gestaobovinaapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.textCadastrarAnimal.setOnClickListener({
            val intent = Intent(this, CadastrarAnimaisActivity::class.java)
            startActivity(intent)
        })

        binding.textCadastrarVacinas.setOnClickListener({
            val intent = Intent(this, CadastrarVacinasActivity::class.java)
            startActivity(intent)
        })

        binding.textVerHistoricoVacinas.setOnClickListener({
            val intent = Intent(this, HistoricoVacinasActivity::class.java)
            startActivity(intent)
        })
    }
}