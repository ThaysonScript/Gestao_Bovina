package com.app.gestaobovinaapp.factory

interface BovinoFactory {
    fun criarTabela() : String
    fun adicionarBovino(nome: String, dataComprado: String, precoCompra: Double, pesoAtual: Double)
}