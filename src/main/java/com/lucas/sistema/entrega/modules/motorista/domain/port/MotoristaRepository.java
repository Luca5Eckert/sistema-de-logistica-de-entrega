package com.lucas.sistema.entrega.modules.motorista.domain.port;

import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

public interface MotoristaRepository {
    void cadastrar(Motorista motorista);

    boolean excluirPorId(long id);

    boolean buscarEntregaDependente(long id);

    boolean buscarPedidoDependente(long id);
}
