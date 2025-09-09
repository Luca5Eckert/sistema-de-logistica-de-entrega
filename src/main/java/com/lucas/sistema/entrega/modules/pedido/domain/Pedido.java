package com.lucas.sistema.entrega.modules.pedido.domain;

import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;

import java.time.LocalDateTime;

public class Pedido {

    private final long id;

    private final long clienteId;

    private final LocalDateTime dataPedido;

    private int volumeM3;

    private int pesoKg;

    private PedidoStatus status;

    public Pedido(long id, long clienteId, LocalDateTime dataPedido, int volumeM3, int pesoKg, PedidoStatus status) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getClienteId() {
        return clienteId;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public int getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(int volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public int getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }
}
