package com.app.gestaobovinaapp.service

import com.app.gestaobovinaapp.factory.BovinoFactory
import com.app.gestaobovinaapp.model.Bovino
import com.app.gestaobovinaapp.model.dto.BovinoDto

class BovinoServiceImpl(private val bovinoDto: BovinoDto) : BovinoFactory {
    fun adicionarBovino(bovino: Bovino): Long {
        return bovinoDto.inserirBovino(bovino)
    }
}