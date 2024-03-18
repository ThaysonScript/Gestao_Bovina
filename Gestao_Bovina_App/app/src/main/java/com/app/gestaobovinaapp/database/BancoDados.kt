package com.app.gestaobovinaapp.database

import android.content.Context
import java.util.Date
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.gestaobovinaapp.model.Bovino

class BancoDados(contexto: Context): SQLiteOpenHelper(contexto, NOME_BANCO, null, VERSAO_BANCO) {
    companion object {
        private const val NOME_BANCO: String = "gestao_bovina.db"
        private const val VERSAO_BANCO: Int = 1
    }

    fun adicionarDados(objeto: Any) {
        if (objeto is Bovino) {
            val dados: String  = bovino(objeto)
            onCreate(dados = dados)

            objeto.
        } else if (objeto is Vacina) {
            vacina(objeto)
        } else {
            println("erro ao adicionar dados!")
        }
    }

    fun bovino() : String {
        val tabela_bovino = """
            CREATE TABLE IF NOT EXISTS ${TABELA_BOVINOS} (${_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${COLUNA_NOME} TEXT, ${COLUNA_DATA_COMPRADO} DATE, ${COLUNA_PRECO_COMPRA} DOUBLE, ${COLUNA_PESO_ATUAL} DOUBLE)
        """.trimIndent()

        return tabela_bovino
    }

    fun vacina() {

    }

    override fun onCreate(db: SQLiteDatabase, dados: String) {
        /*
        val criar_banco_tabela = """
            CREATE TABLE IF NOT EXISTS ${TABELA_BOVINOS} (${_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${COLUNA_NOME} TEXT, ${COLUNA_DATA_COMPRADO} DATE, ${COLUNA_VACINA} TEXT)
            """.trimIndent()

        db.execSQL(criar_banco_tabela)
        */

        db.execSQL(dados)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int, dados: String) {
        /*
        db.execSQL("""
            DROP TABLE IF EXISTS ${TABELA_BOVINOS}
        """.trimIndent())

        onCreate(db)
        */

        onCreate(dados)
    }
}
