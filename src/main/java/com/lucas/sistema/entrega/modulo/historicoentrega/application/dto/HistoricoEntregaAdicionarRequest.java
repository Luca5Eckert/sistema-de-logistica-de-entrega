package com.lucas.sistema.entrega.modulo.historicoentrega.application.dto;

import java.time.LocalDateTime;

public record HistoricoEntregaAdicionarRequest(long entregaId, LocalDateTime dataEvento, String descricao) {
}
