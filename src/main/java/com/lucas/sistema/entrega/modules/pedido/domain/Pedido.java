package com.lucas.sistema.entrega.modules.pedido.domain;

import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;
import com.lucas.sistema.entrega.modules.pedido.domain.exception.PedidoValidacaoCancelamentoException;

import java.time.LocalDateTime;

public class Pedido {

    private final long id;

    private final long clienteId;

    private final LocalDateTime dataPedido;

    private double volumeM3;

    private double pesoKg;

    private PedidoStatus status;

    public Pedido(long id, long clienteId, LocalDateTime dataPedido, double volumeM3, double pesoKg, PedidoStatus status) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.status = status;
    }

    public Pedido(long clienteId, LocalDateTime dataPedido, double volumeM3, double pesoKg, PedidoStatus status) {
        this.id = -1;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.status = status;
    }

    public Pedido(long id) {
        this.id = id;
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

    public double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(int volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        if(verificarCancelamento()) {
            throw new PedidoValidacaoCancelamentoException("O pedido não pode ser cancelado quando já foi entregue");
        }
        this.status = status;
    }

    public boolean verificarCancelamento() {
        return switch(status){
            case ENTREGUE -> false;
            default -> true;
        };
    }
}
