package com.lucas.sistema.entrega.modulo.historicoentrega.application.dto;

import java.time.LocalDateTime;

public record EventoEntregaResponse(long id, LocalDateTime dataEvento, String descricao) {

    @Override
    public String toString() {
        return "| Id: " + id + " | Data Evento: " + dataEvento + " | Descrição: " + descricao;
    }

}
