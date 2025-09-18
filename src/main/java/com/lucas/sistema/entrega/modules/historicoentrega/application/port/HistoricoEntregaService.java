package com.lucas.sistema.entrega.modules.historicoentrega.application.port;

import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;

import java.util.List;

public interface HistoricoEntregaService {

    void adicionar(HistoricoEntrega historicoEntrega);

    List<HistoricoEntrega> pegarEventos();

    List<HistoricoEntrega> pegarHistoricoDeEntrega(long idEntrega);
}
