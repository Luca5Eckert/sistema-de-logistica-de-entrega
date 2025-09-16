package com.lucas.sistema.entrega.modules.pedido.application.dto;

import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;

import java.time.LocalDateTime;

public record PedidoResponse(long id, long clienteId, LocalDateTime dataPedido, double volumeM3, double pesoKg, PedidoStatus pedidoStatus) {

    public String exibirDados() {
        return "| Cliente Id: " + clienteId +
                "\n | Data Pedido: " + dataPedido +
                "\n | Volume em m³: " + volumeM3 +
                "\n | Peso em kg: " + pesoKg
                + "\n | Status: " + pedidoStatus;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Cliente Id: " + clienteId + " | Data Pedido: " + dataPedido + " | Volume em m³: " + volumeM3 + " | Peso em kg: " + pesoKg + " | Status: " + pedidoStatus;

    }
}
