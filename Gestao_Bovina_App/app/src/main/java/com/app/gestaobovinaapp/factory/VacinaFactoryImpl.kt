package com.app.gestaobovinaapp.factory

class VacinaFactoryImpl : VacinaFactory {
    private val TABELA_VACINA: String = "vacinas"
    private val ID: Long = 1
    private val COLUNA_NOME: String = "nome"
    private val COLUNA_DATA_COMPRADO: String = "data_comprado"
    private val COLUNA_PRECO_COMPRA: String = "preco_compra"

    override fun criarTabela(): String {
        val tabela: String = "CREATE IF NOT EXISTS ${TABELA_VACINA} (${ID}) INTEGER PRIMARY KEY AUTOINCREMENT, ${COLUNA_NOME} TEXT, ${COLUNA_DATA_COMPRADO} DATE, ${COLUNA_PRECO_COMPRA} DOUBLE"
        return tabela
    }
    override fun adicionarVacina() : String {
        TODO("Not yet implemented")
    }

    public fun getTabela() : String {
        return this.TABELA_VACINA
    }
}