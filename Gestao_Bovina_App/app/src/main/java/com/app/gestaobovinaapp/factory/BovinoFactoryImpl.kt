package com.app.gestaobovinaapp.factory

import android.content.Context
import com.app.gestaobovinaapp.database.BancoDados

class BovinoFactoryImpl() : BovinoFactory {
    private val TABELA_BOVINOS: String = "bovinos"
    private val ID: Long = 1
    private val COLUNA_NOME: String = "nome"
    private val COLUNA_DATA_COMPRADO: String = "data_comprado"
    private val COLUNA_PRECO_COMPRA: String = "preco_compra"
    private val COLUNA_PESO_ATUAL: String = "peso_atual"

    override fun criarTabela() : String {
        val tabela: String = "CREATE IF NOT EXISTS $TABELA_BOVINOS ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUNA_NOME TEXT, $COLUNA_DATA_COMPRADO DATE, $COLUNA_PRECO_COMPRA DOUBLE, $COLUNA_PESO_ATUAL DOUBLE)"
        return tabela
    }

    override fun adicionarBovino(): Long {
        TODO("Not yet implemented")
    }

    fun getTabela() : String {
        return this.TABELA_BOVINOS
    }
}