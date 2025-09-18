package com.lucas.sistema.entrega.modulo.pedido.domain.port;

import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.modulo.pedido.domain.Pedido;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PedidoRepository {

    void adicionar(Pedido pedido);

    Optional<Pedido> buscar(long pedidoId);

    void salvar(Pedido pedido);

    Map<String, Long> pegarQuantidadePedidosPendentesPorEstado();

    boolean existePorId(long pedidoId);

    List<Pedido> buscarPedidosPorCliente(String cpfCnpj);

    Optional<Pedido> buscarPeloId(long id);

    List<PedidoResponse> pegarPedidos();

}
