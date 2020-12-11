package com.br.guilherme.shared.dominio.evento

import java.time.LocalDateTime

interface Evento {

    fun momento(): LocalDateTime
    fun tipo(): TipoDeEvento
    fun informacoes(): Map<String, Object>

}