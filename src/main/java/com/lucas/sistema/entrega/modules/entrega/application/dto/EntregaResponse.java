package com.lucas.sistema.entrega.modules.entrega.application.dto;

import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record EntregaResponse(long id, long pedidoId, long motoristaId, LocalDateTime dataSaida, EntregaStatus entregaStatus) {

    public String exibirDados() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataTexto = dataSaida.format(formatter);

        return " | Pedido Id: " + pedidoId + "\n | Motorista Id: " + motoristaId + "\n | Data Saida: " + dataTexto + "\n | Entrega status: " + entregaStatus;
    }

}
