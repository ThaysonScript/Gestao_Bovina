package com.app.gestaobovinaapp.factory

interface VacinaFactory {
    fun criarTabela() : String
    fun adicionarVacina(nome: String, dataComprado: String, precoCompra: Double)
}