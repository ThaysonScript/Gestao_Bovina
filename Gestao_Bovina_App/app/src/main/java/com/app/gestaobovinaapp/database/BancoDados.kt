package com.app.gestaobovinaapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.gestaobovinaapp.factory.BovinoFactoryImpl
import com.app.gestaobovinaapp.factory.VacinaFactoryImpl

class BancoDados(context: Context): SQLiteOpenHelper(context, "gestao_bovina.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            val tabelaBovino = BovinoFactoryImpl()
            val tabelaVacina = VacinaFactoryImpl()

            val sql = arrayOf(tabelaBovino.criarTabela(), tabelaVacina.criarTabela())

            for (tabela in sql) {
                db.execSQL(tabela)
            }
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            val tabelaBovino = BovinoFactoryImpl()
            val tabelaVacina = VacinaFactoryImpl()

            val sql = arrayOf(tabelaBovino.getTabela(), tabelaVacina.getTabela())

            for (tabela in sql) {
                db.execSQL("DROP TABLE IF EXISTS $tabela")
                onCreate(db)
            }
        }
    }

}
