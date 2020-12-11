package com.br.guilherme.shared.dominio.evento

abstract class Ouvinte {

    fun processa(evento: Evento) {
        if(this.deveProcessar(evento)){
            this.reageAo(evento)
        }
    }

    abstract fun reageAo(evento: Evento)

    abstract fun deveProcessar(evento: Evento): Boolean

}