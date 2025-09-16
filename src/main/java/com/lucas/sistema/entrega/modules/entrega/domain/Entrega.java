package com.lucas.sistema.entrega.modules.entrega.domain;

import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

import java.time.LocalDateTime;

public class Entrega {

    private final long id;

    private final long pedidoId;

    private final long motoristaId;

    private LocalDateTime dataSaida;

    private LocalDateTime dataEntrega;

    private EntregaStatus status;

    public Entrega(long id, long pedidoId, long motoristaId, LocalDateTime dataSaida, LocalDateTime dataEntrega, EntregaStatus status) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public Entrega(long pedidoId, long motoristaId, LocalDateTime dataSaida, LocalDateTime dataEntrega, EntregaStatus status) {
        this.id = -1;
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }


    public EntregaStatus getStatus() {
        return status;
    }

    public void setStatus(EntregaStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public long getMotoristaId() {
        return motoristaId;
    }

    public long getPedidoId() {
        return pedidoId;
    }

    public long getId() {
        return id;
    }

    public boolean validarMudancaDeStatus() {
        return !status.equals(EntregaStatus.ENTREGUE);

    }

    public boolean validarExclusao() {
        return !status.equals(EntregaStatus.ATRASADA);
    }
}
