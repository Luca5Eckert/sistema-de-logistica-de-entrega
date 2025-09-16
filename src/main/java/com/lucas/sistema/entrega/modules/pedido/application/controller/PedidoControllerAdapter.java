package com.lucas.sistema.entrega.modules.pedido.application.controller;

import com.lucas.sistema.entrega.modules.pedido.application.dto.PedidoAdicionarRequest;
import com.lucas.sistema.entrega.modules.pedido.application.dto.PedidoCancelarRequest;
import com.lucas.sistema.entrega.modules.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.modules.pedido.application.port.PedidoMapper;
import com.lucas.sistema.entrega.modules.pedido.application.port.PedidoService;
import com.lucas.sistema.entrega.view.port.PedidoController;

import java.util.Map;

public class PedidoControllerAdapter implements PedidoController {

    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    public PedidoControllerAdapter(PedidoService pedidoService, PedidoMapper pedidoMapper) {
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoResponse adicionar(PedidoAdicionarRequest pedidoAdicionarRequest){
        var pedido = pedidoMapper.toEntity(pedidoAdicionarRequest);

        pedidoService.adicionarPedido(pedido);

        return pedidoMapper.toResponse(pedido);
    }

    @Override
    public PedidoResponse cancelarPedido(PedidoCancelarRequest pedidoCancelarRequest){
        var idPedido = pedidoCancelarRequest.id();

        var pedido = pedidoService.cancelarPedido(idPedido);

        return pedidoMapper.toResponse(pedido);
    }

    @Override
    public Map<String, Long> pegarQuantidadePedidosPendentesPorEstado(){
        return pedidoService.pegarQuantidadePedidosPendentesPorEstado();
    }

}
