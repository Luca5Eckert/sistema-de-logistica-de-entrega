package com.lucas.sistema.entrega.infraestrutura.persistence.entrega.mapper;

import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaAdicionarRequest;
import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaResponse;
import com.lucas.sistema.entrega.modulo.entrega.application.port.EntregaMapper;
import com.lucas.sistema.entrega.modulo.entrega.domain.Entrega;

public class EntregaMapperAdapter implements EntregaMapper {

    @Override
    public Entrega toEntity(EntregaAdicionarRequest entregaAdicionarRequest) {
        return new Entrega(entregaAdicionarRequest.pedidoId(), entregaAdicionarRequest.motoristaId(), entregaAdicionarRequest.dataSaida(), null, entregaAdicionarRequest.entregaStatus());
    }

    @Override
    public EntregaResponse toResponse(Entrega entrega) {
        return new EntregaResponse(entrega.getId(), entrega.getPedidoId(), entrega.getMotoristaId(), entrega.getDataSaida(), entrega.getStatus());
    }
}
