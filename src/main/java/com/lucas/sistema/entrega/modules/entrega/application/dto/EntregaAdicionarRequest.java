package com.lucas.sistema.entrega.modules.entrega.application.dto;

import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

import java.time.LocalDateTime;

public record EntregaAdicionarRequest(long pedidoId, long motoristaId, LocalDateTime dataSaida, EntregaStatus entregaStatus) {
}
