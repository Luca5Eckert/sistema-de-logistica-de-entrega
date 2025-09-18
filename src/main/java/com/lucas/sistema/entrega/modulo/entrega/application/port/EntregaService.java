package com.lucas.sistema.entrega.modulo.entrega.application.port;

import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteEntregaResponse;
import com.lucas.sistema.entrega.modulo.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modulo.entrega.domain.enumerator.EntregaStatus;

import java.util.List;
import java.util.Map;

public interface EntregaService {

    void adicionar(Entrega entrega);

    Entrega atualizarStatus(long id, EntregaStatus entregaStatus);

    List<Entrega> pegarEntregas();

    long pegarQuantidadeEntregasPorMotorista(long idMotorista);

    List<ClienteEntregaResponse> pegarClientesComMaiorQuantidadeEntregas();

    void excluirEntrega(long id);

    Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade();

    Entrega pegarEntrega(long idEntrega);
}
