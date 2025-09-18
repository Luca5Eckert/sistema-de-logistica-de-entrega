package com.lucas.sistema.entrega.modules.entrega.domain.port;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteEntregaResponse;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EntregaRepository {

    void adicionar(Entrega entrega);

    Optional<Entrega> buscarPorId(long id);

    void save(Entrega entrega);

    Optional<List<Entrega>> pegarTodas();

    long pegarQuantidadeEntregaPorMotorista(long idMotorista);


    /**
     * Método responsavel por pegar os clientes por maior quantidade de entregas
     *
     * <p>Esse método pegará os cinco clientes com maior quantidade de entregas
     * , eles serão organizados de maior para o menor </p>
     *
     * @return devolve uma lista de clientes
     */
    List<ClienteEntregaResponse> pegarClientesComMaiorQuantidadeEntregas();

    void excluirPorId(long id);

    Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade();
}
