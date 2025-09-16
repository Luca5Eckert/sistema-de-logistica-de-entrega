package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaResponse;

public interface HistoricoEntregaController {

    HistoricoEntregaResponse adicionar(HistoricoEntregaAdicionarRequest historicoEntregaAdicionarRequest);

}
