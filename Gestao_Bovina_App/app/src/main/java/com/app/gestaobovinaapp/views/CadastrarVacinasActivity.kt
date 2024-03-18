package com.app.gestaobovinaapp.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.database.BancoDados
import com.app.gestaobovinaapp.databinding.ActivityCadastrarVacinasBinding

class CadastrarVacinasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarVacinasBinding
    private lateinit var db: BancoDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarVacinasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = BancoDados(this)

        binding.buttonSubmit.setOnClickListener {
            val nomeVacina = binding.editVaccineName.text.toString()
            val numeroAnimal = binding.editAnimalNumber.text.toString()
            val dataAdmin = binding.editDateAdministered.text.toString()
            val notas = binding.editNotes.text.toString()

            if (nomeVacina.isNotEmpty() && numeroAnimal.isNotEmpty() && dataAdmin.isNotEmpty()) {
                val id = db.inserirVacina(nomeVacina, numeroAnimal, dataAdmin, notas)
                if (id != -1L) {
                    Toast.makeText(this, "Vacina registrada com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erro ao registrar vacina", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
