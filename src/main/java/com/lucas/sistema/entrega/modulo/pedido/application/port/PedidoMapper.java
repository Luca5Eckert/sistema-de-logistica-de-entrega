package com.lucas.sistema.entrega.modulo.pedido.application.port;

import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoAdicionarRequest;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoCancelarRequest;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.modulo.pedido.domain.Pedido;

public interface PedidoMapper {

    Pedido toEntity(PedidoCancelarRequest pedidoCancelarRequest);

    Pedido toEntity(PedidoAdicionarRequest pedidoAdicionarRequest);

    PedidoResponse toResponse(Pedido pedido);

}
