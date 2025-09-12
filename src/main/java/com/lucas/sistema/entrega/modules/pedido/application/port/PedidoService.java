package com.lucas.sistema.entrega.modules.pedido.application.port;

import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;

import java.util.Map;

public interface PedidoService {

    void adicionarPedido(Pedido pedido);

    Pedido cancelarPedido(long idPedido);

    Map<String, Long> pegarQuantidadePedidosPendentesPorEstado();
}
