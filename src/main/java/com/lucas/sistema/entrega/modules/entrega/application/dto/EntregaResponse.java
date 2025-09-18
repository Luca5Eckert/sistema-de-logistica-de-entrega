package com.lucas.sistema.entrega.modules.entrega.application.dto;

import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record EntregaResponse(long id, long pedidoId, long motoristaId, LocalDateTime dataSaida, EntregaStatus entregaStatus) {

    public String exibirDados() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataTexto = dataSaida.format(formatter);

        return " | Pedido Id: " + pedidoId + " | Motorista Id: " + motoristaId + " | Data Saida: " + dataTexto + " | Entrega status: " + entregaStatus;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataTexto = dataSaida.format(formatter);

        return "Id: " + id + " | Pedido Id: " + pedidoId + " | Motorista Id: " + motoristaId + " | Data Saida: " + dataTexto + " | Entrega status: " + entregaStatus;

    }
}
