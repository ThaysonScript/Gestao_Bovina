package com.app.gestaobovinaapp.database

import android.content.ContentValues.TAG
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import android.util.Log
import com.app.gestaobovinaapp.factory.BovinoFactoryImpl
import com.app.gestaobovinaapp.factory.VacinaFactoryImpl
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class BancoDados(context: Context): SQLiteOpenHelper(context, "gestao_bovina.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            val tabelaBovino = BovinoFactoryImpl(this)
            val tabelaVacina = VacinaFactoryImpl(this)

            db.execSQL(tabelaBovino.criarTabela())
            db.execSQL(tabelaVacina.criarTabela())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            val tabelaBovino = BovinoFactoryImpl(this)
            val tabelaVacina = VacinaFactoryImpl(this)

            val sql = arrayOf(tabelaBovino.getTabela(), tabelaVacina.getTabela())

            for (tabela in sql) {
                db.execSQL("DROP TABLE IF EXISTS $tabela")
                onCreate(db)
            }
        }
    }
}
