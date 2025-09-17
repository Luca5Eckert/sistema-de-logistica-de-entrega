package com.lucas.sistema.entrega.modules.pedido.application.port;

import com.lucas.sistema.entrega.modules.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;

import java.util.List;
import java.util.Map;

public interface PedidoService {

    void adicionarPedido(Pedido pedido);

    Pedido cancelarPedido(long idPedido);

    Map<String, Long> pegarQuantidadePedidosPendentesPorEstado();

    List<Pedido> buscarPedidosPorCliente(String documento);

    Pedido buscarPeloId(long id);

    List<PedidoResponse> pegarPedidos();
}
