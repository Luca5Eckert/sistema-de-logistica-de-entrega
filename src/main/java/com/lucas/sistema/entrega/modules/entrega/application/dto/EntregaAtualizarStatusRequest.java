package com.lucas.sistema.entrega.modules.entrega.application.dto;

import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

public record EntregaAtualizarStatusRequest(long idEntrega, EntregaStatus novoStatus) {
}
