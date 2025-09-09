package com.lucas.sistema.entrega.modules.historicoentrega.domain.port;

import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;

public interface HistoricoEntregaRepository {
    void adicionar(HistoricoEntrega historicoEntrega);
}
