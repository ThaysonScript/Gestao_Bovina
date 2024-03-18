package com.app.gestaobovinaapp.factory

class BovinoFactoryImpl : BovinoFactory {
    companion object {
        private const val TABELA_BOVINOS: String = "bovinos"
        private const val _ID: Long = 1
        private const val COLUNA_NOME: String = "nome"
        private const val COLUNA_DATA_COMPRADO: String = "data_comprado"
        private const val COLUNA_PRECO_COMPRA: String = "preco_compra"
        private const val COLUNA_PESO_ATUAL: String = "peso_atual"
    }

    override fun adicionarBovino(bovino: Bovino): Long {
        val values = ContentValues().apply {
            put(COLUNA_NOME, bovino.nome)
            put(COLUNA_DATA_COMPRADO, bovino.dataComprado.time) // Convertendo Date para timestamp Unix
            put(COLUNA_PRECO_COMPRA, bovino.vacina)
        }
        return dbHelper.insert(TABELA_BOVINOS, null, values)
    }
}