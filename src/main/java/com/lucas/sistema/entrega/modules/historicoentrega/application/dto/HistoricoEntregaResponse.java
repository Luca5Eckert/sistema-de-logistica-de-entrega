package com.lucas.sistema.entrega.modules.historicoentrega.application.dto;

import java.time.LocalDateTime;

public record HistoricoEntregaResponse(long id, long entregaId, LocalDateTime dataEvento, String descricao) {
}
