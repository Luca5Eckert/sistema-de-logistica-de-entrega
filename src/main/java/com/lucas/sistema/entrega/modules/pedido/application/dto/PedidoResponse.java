package com.lucas.sistema.entrega.modules.pedido.application.dto;

import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;

import java.time.LocalDateTime;

public record PedidoResponse(long id, long clienteId, LocalDateTime dataPedido, double volumeM3, double pesoKg, PedidoStatus pedidoStatus) {
}
