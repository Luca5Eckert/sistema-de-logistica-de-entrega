package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoAdicionarRequest;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoCancelarRequest;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoResponse;

import java.util.List;
import java.util.Map;

public interface PedidoController {

    PedidoResponse adicionar(PedidoAdicionarRequest pedidoAdicionarRequest);

    PedidoResponse cancelarPedido(PedidoCancelarRequest pedidoCancelarRequest);

    Map<String, Long> pegarQuantidadePedidosPendentesPorEstado();

    PedidoResponse buscarPeloId(long id);

    List<PedidoResponse> buscarPedidosPorCliente(String cpfCnpj);

    List<PedidoResponse> pegarPedidos();

}