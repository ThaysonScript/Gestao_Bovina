package com.app.gestaobovinaapp.factory

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import com.app.gestaobovinaapp.database.BancoDados
import com.app.gestaobovinaapp.model.Bovino

class BovinoFactoryImpl(private val bancoDados: BancoDados) : BovinoFactory {
    private val TABELA_BOVINOS: String = "bovinos"
    private val ID: Long = 1
    private val COLUNA_NOME: String = "nome"
    private val COLUNA_DATA_COMPRADO: String = "data_comprado"
    private val COLUNA_PRECO_COMPRA: String = "preco_compra"
    private val COLUNA_PESO_ATUAL: String = "peso_atual"

    override fun criarTabela() : String {
        val tabela: String = "CREATE TABLE IF NOT EXISTS $TABELA_BOVINOS (id INTEGER PRIMARY KEY AUTOINCREMENT, $COLUNA_NOME TEXT, $COLUNA_DATA_COMPRADO DATE, $COLUNA_PRECO_COMPRA DOUBLE, $COLUNA_PESO_ATUAL DOUBLE)"
        return tabela
    }

    override fun adicionarBovino(
        nome: String,
        dataComprado: String,
        precoCompra: Double,
        pesoAtual: Double
    ) {
        val db = bancoDados.writableDatabase

        val bovinos = ContentValues().apply {
            put(COLUNA_NOME, nome)
            put(COLUNA_DATA_COMPRADO, dataComprado)
            put(COLUNA_PRECO_COMPRA, precoCompra)
            put(COLUNA_PESO_ATUAL, pesoAtual)
        }

        db.insert(TABELA_BOVINOS, null, bovinos)
        db.close()
    }

    fun obterTodosBovinos() {

    }


    fun getTabela() : String {
        return this.TABELA_BOVINOS
    }
}