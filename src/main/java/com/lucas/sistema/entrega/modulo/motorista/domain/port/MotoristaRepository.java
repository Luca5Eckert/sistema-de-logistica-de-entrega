package com.lucas.sistema.entrega.modulo.motorista.domain.port;

import com.lucas.sistema.entrega.modulo.motorista.domain.Motorista;

import java.util.List;
import java.util.Optional;

public interface MotoristaRepository {

    void cadastrar(Motorista motorista);

    boolean excluirPorId(long id);

    boolean buscarEntregaDependente(long id);

    boolean buscarPedidoDependente(long id);

    boolean existePorId(long motoristaId);

    List<Motorista> pegarMotoristas();

    Optional<Motorista> buscarPeloId(long id);
}
