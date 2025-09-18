package com.lucas.sistema.entrega.modulo.entrega.application.dto;

import com.lucas.sistema.entrega.modulo.entrega.domain.enumerator.EntregaStatus;

public record EntregaAtualizarStatusRequest(long idEntrega, EntregaStatus novoStatus) {
}
