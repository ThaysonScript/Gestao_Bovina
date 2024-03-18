package com.app.gestaobovinaapp.factory

import android.content.ContentValues
import com.app.gestaobovinaapp.database.BancoDados

class VacinaFactoryImpl(private val bancoDados: BancoDados) : VacinaFactory {
    private val TABELA_VACINA: String = "vacinas"
    private val ID: Long = 1
    private val COLUNA_NOME: String = "nome"
    private val COLUNA_DATA_COMPRADO: String = "data_comprado"
    private val COLUNA_PRECO_COMPRA: String = "preco_compra"

    override fun criarTabela(): String {
        val tabela: String = "CREATE TABLE IF NOT EXISTS ${TABELA_VACINA} (id INTEGER PRIMARY KEY AUTOINCREMENT, ${COLUNA_NOME} TEXT, ${COLUNA_DATA_COMPRADO} DATE, ${COLUNA_PRECO_COMPRA} DOUBLE)"
        return tabela
    }
    override fun adicionarVacina(
        nome: String,
        dataComprado: String,
        precoCompra: Double
    ) {
        val db = bancoDados.writableDatabase

        val vacinas = ContentValues().apply {
            put(COLUNA_NOME, nome)
            put(COLUNA_DATA_COMPRADO, dataComprado)
            put(COLUNA_PRECO_COMPRA, precoCompra)
        }

        db.insert(TABELA_VACINA, null, vacinas)
        db.close()
    }

    public fun getTabela() : String {
        return this.TABELA_VACINA
    }
}