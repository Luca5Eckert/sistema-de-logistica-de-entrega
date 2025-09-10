package com.lucas.sistema.entrega.modules.entrega.application.port;

import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

public interface EntregaService {

    void adicionar(Entrega entrega);

    Entrega atualizarStatus(long id, EntregaStatus entregaStatus);
}
