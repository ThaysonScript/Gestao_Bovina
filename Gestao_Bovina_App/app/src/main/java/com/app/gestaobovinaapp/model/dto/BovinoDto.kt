package com.app.gestaobovinaapp.model.dto

import android.content.ContentValues
import com.app.gestaobovinaapp.database.BancoDados
import com.app.gestaobovinaapp.model.Bovino

class BovinoDto(private val bancoDados: BancoDados) {
    fun inserirBovino(bovino: Bovino): Long {
        val db = bancoDados.writableDatabase

        val valores = ContentValues().apply {
            put(COLUNA_NOME, bovino.nome)
            put(COLUNA_DATA_COMPRADO, bovino.dataComprado.time) // Convertendo Date para timestamp Unix
        }

        return db.insert(TABELA_BOVINOS, null, valores)
    }
}