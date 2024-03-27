package com.app.gestaobovinaapp

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.gestaobovinaapp.database.CriarBancoDados
import com.app.gestaobovinaapp.databinding.ActivityMainBinding
import com.app.gestaobovinaapp.views.HomeActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val banco = CriarBancoDados(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

        importarBancoDeDados()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Exporta o banco de dados antes de fechar o aplicativo
        exportarBancoDeDados()
    }

    private fun exportarBancoDeDados() {
        val nomeBanco = "gestao_bovina.db"
        val diretorioOrigem = getDatabasePath(nomeBanco)
        val diretorioDestino = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), nomeBanco)

        try {
            val inputStream = FileInputStream(diretorioOrigem)
            val outputStream = FileOutputStream(diretorioDestino)
            val buffer = ByteArray(1024)
            var length: Int

            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }

            outputStream.flush()
            outputStream.close()
            inputStream.close()

            println("Banco de dados exportado com sucesso para: $diretorioDestino")
        } catch (e: IOException) {
            println("Erro ao exportar o banco de dados: ${e.message}")
        }
    }

    private fun importarBancoDeDados() {
        val diretorioOrigem = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "gestao_bovina.db")
        try {
            val inputStream = FileInputStream(diretorioOrigem)
            val outputStream = FileOutputStream(getDatabasePath("gestao_bovina.db"))
            val buffer = ByteArray(1024)
            var length: Int
            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
            Log.d(ContentValues.TAG, "Banco de dados importado com sucesso de: $diretorioOrigem")
        } catch (e: IOException) {
            Log.e(ContentValues.TAG, "Erro ao importar o banco de dados", e)
        }
    }

}