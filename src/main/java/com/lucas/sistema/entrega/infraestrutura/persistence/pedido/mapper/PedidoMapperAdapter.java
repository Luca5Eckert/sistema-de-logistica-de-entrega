package com.lucas.sistema.entrega.infraestrutura.persistence.pedido.mapper;

import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoAdicionarRequest;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoCancelarRequest;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.modulo.pedido.application.port.PedidoMapper;
import com.lucas.sistema.entrega.modulo.pedido.domain.Pedido;

public class PedidoMapperAdapter implements PedidoMapper {

    @Override
    public Pedido toEntity(PedidoCancelarRequest pedidoCancelarRequest) {
        return new Pedido(pedidoCancelarRequest.id());
    }

    @Override
    public Pedido toEntity(PedidoAdicionarRequest pedidoAdicionarRequest) {
        return new Pedido(pedidoAdicionarRequest.clienteId(), pedidoAdicionarRequest.dataPedido(), pedidoAdicionarRequest.volumeM3(), pedidoAdicionarRequest.pesoKg(), pedidoAdicionarRequest.pedidoStatus());
    }

    @Override
    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getClienteId(), pedido.getDataPedido(), pedido.getVolumeM3(), pedido.getPesoKg(), pedido.getStatus());
    }

}
