package com.lucas.sistema.entrega.modules.historicoentrega.application.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record HistoricoEntregaResponse(long id, long entregaId, LocalDateTime dataEvento, String descricao) {

    public String exibirDados() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataTexto = dataEvento.format(formatter);

        return " | Entrega Id: " + entregaId + "\n | Data evento: " + dataTexto + "\n | Descrição: " + descricao;
    }

}
