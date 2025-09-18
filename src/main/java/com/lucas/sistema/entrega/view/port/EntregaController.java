package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteEntregaResponse;
import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaAdicionarRequest;
import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaAtualizarStatusRequest;
import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaExcluirRequest;
import com.lucas.sistema.entrega.modulo.entrega.application.dto.EntregaResponse;

import java.util.List;
import java.util.Map;

public interface EntregaController {

    EntregaResponse adicionar(EntregaAdicionarRequest entregaAdicionarRequest);

    void excluirEntrega(EntregaExcluirRequest entregaExcluirRequest);

    EntregaResponse atualizarStatus(EntregaAtualizarStatusRequest entregaAtualizarStatusRequest);

    List<EntregaResponse> pegarEntregas();

    long pegarTotalEntregasPorMotorista(long idMotorista);

    List<ClienteEntregaResponse> pegarClientesComMaiorQuantidadeEntregas();

    Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade();

    EntregaResponse pegarEntrega(long idEntrega);

}
