package com.lucas.sistema.entrega.modulo.historicoentrega.application.port;

import com.lucas.sistema.entrega.modulo.historicoentrega.application.dto.EventoEntregaResponse;
import com.lucas.sistema.entrega.modulo.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.modulo.historicoentrega.application.dto.HistoricoEntregaResponse;
import com.lucas.sistema.entrega.modulo.historicoentrega.domain.HistoricoEntrega;

public interface HistoricoEntregaMapper {

    HistoricoEntrega toEntity(HistoricoEntregaAdicionarRequest entregaAdicionarRequest);

    HistoricoEntregaResponse toResponse(HistoricoEntrega historicoEntrega);

    EventoEntregaResponse toResponseHistoricoEntrega(HistoricoEntrega historicoEntrega);
}
