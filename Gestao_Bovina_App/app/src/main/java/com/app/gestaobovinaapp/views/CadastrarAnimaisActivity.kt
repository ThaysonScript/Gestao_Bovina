package com.app.gestaobovinaapp.views

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.databinding.ActivityCadastrarAnimaisBinding
import com.app.gestaobovinaapp.service.BovinoServiceImpl
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CadastrarAnimaisActivity : AppCompatActivity() {
    private val PICK_IMAGE = 1
    private lateinit var binding: ActivityCadastrarAnimaisBinding
    private var imagemSelecionadaBitmap: Bitmap? = null
    private val inputDateFormat = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
    private val outputDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private var isFormatting = false
    private val banco: BovinoServiceImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastrarAnimaisBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSelecionarImagem.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE)
        }

        binding.editTextDate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!isFormatting) {
                    s?.let { formatarData(it) }
                }
            }
        })
        
        binding.botaoSalvar.setOnClickListener() {
            val nomeBovino = binding.idNomeBovino.text.toString()
            
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            val uriImagemSelecionada: Uri? = data.data
            uriImagemSelecionada?.let {
                try {
                    imagemSelecionadaBitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(it))
                    imagemSelecionadaBitmap?.let { bitmap ->
                        binding.imageView.setImageBitmap(bitmap)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Erro ao carregar a imagem.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun salvarImagem() {
        imagemSelecionadaBitmap?.let { bitmap ->
            val diretorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val nomeArquivo = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date()) + ".jpg"
            val arquivo = File(diretorio, nomeArquivo)

            try {
                val outputStream = FileOutputStream(arquivo)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                outputStream.flush()
                outputStream.close()

                // Notifica a galeria sobre a nova imagem
                MediaStore.Images.Media.insertImage(contentResolver, arquivo.absolutePath, nomeArquivo, null)

                Toast.makeText(this, "Imagem salva em: ${arquivo.absolutePath}", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Erro ao salvar a imagem.", Toast.LENGTH_SHORT).show()
            }
        } ?: run {
            Toast.makeText(this, "Selecione uma imagem primeiro.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun formatarData(s: Editable) {
        val texto = s.toString()
        if (texto.isEmpty() || texto.length < 8) return

        try {
            val data = inputDateFormat.parse(texto)
            val dataFormatada = outputDateFormat.format(data)

            if (dataFormatada != texto) {
                isFormatting = true
                binding.editTextDate.setText(dataFormatada)
                binding.editTextDate.setSelection(dataFormatada.length)
            }
        } catch (e: Exception) {
            // Trate exceções de análise de data aqui, se necessário
            e.printStackTrace()
        } finally {
            isFormatting = false
        }
    }
    
    fun salvarAnimal() {
        
    }
}