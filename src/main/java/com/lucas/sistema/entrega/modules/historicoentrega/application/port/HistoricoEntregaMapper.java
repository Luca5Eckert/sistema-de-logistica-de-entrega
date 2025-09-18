package com.lucas.sistema.entrega.modules.historicoentrega.application.port;

import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.EventoEntregaResponse;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaResponse;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;

public interface HistoricoEntregaMapper {

    HistoricoEntrega toEntity(HistoricoEntregaAdicionarRequest entregaAdicionarRequest);

    HistoricoEntregaResponse toResponse(HistoricoEntrega historicoEntrega);

    EventoEntregaResponse toResponseHistoricoEntrega(HistoricoEntrega historicoEntrega);
}
