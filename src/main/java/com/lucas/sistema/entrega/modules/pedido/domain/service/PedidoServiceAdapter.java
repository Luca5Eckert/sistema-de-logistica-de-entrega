package com.lucas.sistema.entrega.modules.pedido.domain.service;

import com.lucas.sistema.entrega.modules.pedido.application.port.PedidoService;
import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;
import com.lucas.sistema.entrega.modules.pedido.domain.exception.PedidoNullException;
import com.lucas.sistema.entrega.modules.pedido.domain.port.PedidoRepository;

public class PedidoServiceAdapter implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceAdapter(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        if(pedido == null){
            throw new PedidoNullException("O Pedido não pode estar vazio");
        }
        pedidoRepository.adicionar(pedido);
    }
    
}
