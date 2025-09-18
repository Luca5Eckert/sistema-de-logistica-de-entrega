package com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.mapper;

import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.EventoEntregaResponse;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaResponse;
import com.lucas.sistema.entrega.modules.historicoentrega.application.port.HistoricoEntregaMapper;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;

public class HistoricoEntregaMapperAdapter implements HistoricoEntregaMapper {

    @Override
    public HistoricoEntrega toEntity(HistoricoEntregaAdicionarRequest entregaAdicionarRequest) {
        return new HistoricoEntrega(entregaAdicionarRequest.entregaId(), entregaAdicionarRequest.dataEvento(), entregaAdicionarRequest.descricao());
    }

    @Override
    public HistoricoEntregaResponse toResponse(HistoricoEntrega historicoEntrega) {
        return new HistoricoEntregaResponse(historicoEntrega.getId(), historicoEntrega.getEntregaId(), historicoEntrega.getDataEvento(), historicoEntrega.getDescricao());
    }

    @Override
    public EventoEntregaResponse toResponseHistoricoEntrega(HistoricoEntrega historicoEntrega) {
        return new EventoEntregaResponse(historicoEntrega.getId(), historicoEntrega.getDataEvento(), historicoEntrega.getDescricao());
    }

}
