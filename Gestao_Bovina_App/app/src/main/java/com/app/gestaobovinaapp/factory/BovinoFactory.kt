package com.app.gestaobovinaapp.factory

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

class BovinoFactory(private val db: SQLiteDatabase) {
    private val tabela: String = "bovinos"

    private val nome: String = "nome"
    private val nomeDescricao: String = "nomeDescricao"

    private val dataComprado: String = "dataComprado"
    private val dataCompradoDescricao: String = "dataCompradoDescricao"

    private val precoCompra: String = "precoCompra"
    private val precoCompraDescricao: String = "precoCompraDescricao"

    private val pesagem: String = "pesagem"
    private val pesagemDescricao: String = "pesagemDescricao"

    private val dataPesagem: String = "dataPesagem"
    private val dataPesagemescricao: String = "dataPesagemDescricao"

    private val descricaoAnimal: String = "descricaoAnimal"

    fun criarTabelaBovino() {
        db.execSQL("" +
                "CREATE TABLE IF NOT EXISTS $tabela " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$nome TEXT, " +
                "$nomeDescricao TEXT, " +
                "$dataComprado DATE, " +
                "$dataCompradoDescricao TEXT, " +
                "$precoCompra DOUBLE, " +
                "$precoCompraDescricao TEXT, " +
                "$pesagem DOUBLE, " +
                "$pesagemDescricao TEXT, " +
                "$dataPesagem DATE, " +
                "$dataPesagemescricao TEXT," +
                "$descricaoAnimal TEXT" +
                ")" +
                "")
    }

    fun reconstruirTabelaBovinos() {
        db.execSQL("DROP TABLE IF EXISTS $tabela")
        criarTabelaBovino()
    }

    fun adicionarBovino(
        _nome: String,
        _nomeDescricao: String,
        _dataComprado: String,
        _dataCompradoDescricao: String,
        _precoCompra: Double,
        _precoCompraDescricao: Double,
        _pesagem: Double,
        _pesagemDescricao: Double,
        _dataPesagem: String,
        _dataPesagemDescricao: String,
        _descricaoAnimal: String
        ) {
        val contentValues = ContentValues().apply {
            put("nome", _nome)
            put("nomeDescricao", _nomeDescricao)

            put("dataComprado", _dataComprado)
            put("dataCompradoDescricao", _dataCompradoDescricao)

            put("precoCompra", _precoCompra)
            put("precoCompraDescricao", _precoCompraDescricao)

            put("pesagem", _pesagem)
            put("pesagemDescricao", _pesagemDescricao)

            put("dataPesagem", _dataPesagem)
            put("dataPesagemDescricao", _dataPesagemDescricao)

            put("descricaoAnimal", _descricaoAnimal)
        }

        db.insert("bovinos", null, contentValues)
    }
}