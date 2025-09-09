package com.lucas.sistema.entrega.modules.historicoentrega.domain;

import java.time.LocalDateTime;

public class HistoricoEntrega {

    private final long id;

    private final long entregaId;

    private final LocalDateTime dataEvento;

    private String descricao;

    public HistoricoEntrega(long id, long entregaId, LocalDateTime dataEvento, String descricao) {
        this.id = id;
        this.entregaId = entregaId;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public long getEntregaId() {
        return entregaId;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
