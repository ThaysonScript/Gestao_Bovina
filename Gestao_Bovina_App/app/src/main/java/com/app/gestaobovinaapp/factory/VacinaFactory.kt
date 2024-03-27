package com.app.gestaobovinaapp.factory

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import java.util.Date

class VacinaFactory(private val db: SQLiteDatabase) {
    private val tabela: String = "vacinas"
    private val nome: String = "nome"
    private val preco: String = "preco"
    private val dataCompra: String = "dataCompra"

    private val descricaoVacina: String = "descricaoVacina"

    fun criarTabelaVacina() {
        db.execSQL("CREATE TABLE IF NOT EXISTS $tabela (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$nome TEXT, " +
                "$preco DOUBLE, " +
                "$dataCompra DATE, " +
                "$descricaoVacina TEXT" +
                ")")
    }

    fun reconstruirTabelaVacinas() {
        db.execSQL("DROP TABLE IF EXISTS $tabela")
        criarTabelaVacina()
    }

    fun adicionarVacina(
        _nome: String,
        _preco: Double,
        _dataCompra: String,
        _descricaoVacina: String
    ) {
        val contentValues = ContentValues().apply {
            put("nome", _nome)
            put("preco", _preco)
            put("dataCompra", _dataCompra)
            put("descricaoVacina", _descricaoVacina)
        }
    }
}