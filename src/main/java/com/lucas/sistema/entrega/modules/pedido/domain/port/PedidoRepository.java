package com.lucas.sistema.entrega.modules.pedido.domain.port;

import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;

public interface PedidoRepository {

    void adicionar(Pedido pedido);
}
