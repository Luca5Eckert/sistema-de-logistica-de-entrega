package com.lucas.sistema.entrega.modules.motorista.domain.port;

import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

import java.util.List;

public interface MotoristaRepository {

    void cadastrar(Motorista motorista);

    boolean excluirPorId(long id);

    boolean buscarEntregaDependente(long id);

    boolean buscarPedidoDependente(long id);

    boolean existePorId(long motoristaId);

    List<Motorista> pegarMotoristas();

    Motorista buscarPeloId(long id);
}
