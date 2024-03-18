package com.app.gestaobovinaapp.model

import java.util.Date

class Bovino(val id: Long, val nome: String, val dataComprado: String, val precoCompra: Double, val pesoAtual: Double) {
    override fun toString(): String {
        return "ID: $id, Nome: $nome, Data Comprado: $dataComprado, Preço Compra: $precoCompra, Peso Atual: $pesoAtual\n"
    }
}