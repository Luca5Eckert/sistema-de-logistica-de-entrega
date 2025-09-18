package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.EventoEntregaResponse;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaResponse;

import java.util.List;

public interface HistoricoEntregaController {

    HistoricoEntregaResponse adicionar(HistoricoEntregaAdicionarRequest historicoEntregaAdicionarRequest);

    List<HistoricoEntregaResponse> pegarEventos();

    List<EventoEntregaResponse> pegarHistoricoDeEntrega(long idEntrega);

}
