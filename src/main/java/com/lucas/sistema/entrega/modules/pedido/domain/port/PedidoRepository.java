package com.lucas.sistema.entrega.modules.pedido.domain.port;

import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;

import java.util.Map;
import java.util.Optional;

public interface PedidoRepository {

    void adicionar(Pedido pedido);

    Optional<Pedido> buscar(long pedidoId);

    void salvar(Pedido pedido);

    Map<String, Long> pegarQuantidadePedidosPendentesPorEstado();
}
