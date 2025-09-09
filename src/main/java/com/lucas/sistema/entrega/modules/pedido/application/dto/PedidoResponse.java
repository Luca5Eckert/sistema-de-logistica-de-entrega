package com.lucas.sistema.entrega.modules.pedido.application.dto;

import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;

import java.time.LocalDateTime;

public record PedidoResponse(long clienteId, LocalDateTime dataPedido, int volumeM3, int pesoKg, PedidoStatus pedidoStatus) {
}
