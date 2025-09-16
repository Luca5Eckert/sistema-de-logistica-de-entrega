package com.lucas.sistema.entrega.modules.entrega.application.port;

import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

import java.util.List;
import java.util.Map;

public interface EntregaService {

    void adicionar(Entrega entrega);

    Entrega atualizarStatus(long id, EntregaStatus entregaStatus);

    List<Entrega> pegarEntregas();

    long pegarQuantidadeEntregasPorMotorista(long idMotorista);

    List<Cliente> pegarClientesComMaiorQuantidadeEntregas();

    void excluirEntrega(long id);

    Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade();

    Entrega pegarEntrega(long idEntrega);
}
