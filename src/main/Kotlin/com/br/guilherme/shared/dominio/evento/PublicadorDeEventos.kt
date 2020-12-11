package com.br.guilherme.shared.dominio.evento

class PublicadorDeEventos {

    private var ouvintes: MutableList<Ouvinte> = ArrayList()


    fun adicionar(ouvinte: Ouvinte) {
        this.ouvintes.add(ouvinte)
    }

    fun publicar(evento: Evento) {
        this.ouvintes.forEach{o -> (
            o.processa(evento)
                )}
    }
}