package com.app.gestaobovinaapp.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.database.CriarBancoDados
import com.app.gestaobovinaapp.databinding.ActivityCadastrarVacinasBinding
import com.app.gestaobovinaapp.factory.factoryImpl.VacinaFactoryImpl

class CadastrarVacinasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarVacinasBinding
    private lateinit var db: CriarBancoDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarVacinasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = CriarBancoDados(this)

        binding.buttonSubmit.setOnClickListener {
            val nomeVacina = binding.editVaccineName.text.toString()
            val numeroAnimal = binding.editAnimalNumber.text.toString()
            // val dataAdmin = binding.editDateAdministered.text.toString()
            val dataAdmin = 7.8
            //val notas = binding.editNotes.text.toString()
            //val notas = 12.3

            val db = CriarBancoDados(this)
            val vacina = VacinaFactoryImpl(db)

            if (nomeVacina.isNotEmpty() && numeroAnimal.isNotEmpty()) {
                val id = vacina.adicionarVacina(nomeVacina, numeroAnimal, dataAdmin)
                if (id != null) {
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
