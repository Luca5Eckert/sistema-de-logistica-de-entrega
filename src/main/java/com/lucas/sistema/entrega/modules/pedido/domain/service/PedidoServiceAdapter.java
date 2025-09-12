package com.lucas.sistema.entrega.modules.pedido.domain.service;

import com.lucas.sistema.entrega.modules.pedido.application.port.PedidoService;
import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;
import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;
import com.lucas.sistema.entrega.modules.pedido.domain.exception.PedidoNullException;
import com.lucas.sistema.entrega.modules.pedido.domain.exception.PedidoValidacaoCancelamentoException;
import com.lucas.sistema.entrega.modules.pedido.domain.port.PedidoRepository;

import java.util.Map;

public class PedidoServiceAdapter implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceAdapter(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        verificarPedidoNulo(pedido);

        pedidoRepository.adicionar(pedido);
    }

    @Override
    public Pedido cancelarPedido(long pedidoId) {
        Pedido pedido = pedidoRepository.buscar(pedidoId).orElseThrow(() -> new PedidoNullException("Não encontrado pedido com id: " + pedidoId));

        pedido.setStatus(PedidoStatus.CANCELADO);

        pedidoRepository.salvar(pedido);

        return pedido;
    }

    @Override
    public Map<String, Long> pegarQuantidadePedidosPendentesPorEstado() {
        return pedidoRepository.pegarQuantidadePedidosPendentesPorEstado();
    }

    private void verificarPedidoNulo(Pedido pedido){
        if(pedido == null) throw new PedidoNullException("O Pedido não pode estar vazio");
    }

}
