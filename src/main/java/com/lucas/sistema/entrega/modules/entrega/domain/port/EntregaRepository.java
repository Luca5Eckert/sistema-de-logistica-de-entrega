package com.lucas.sistema.entrega.modules.entrega.domain.port;

import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;

import java.util.Optional;

public interface EntregaRepository {

    void adicionar(Entrega entrega);

    Optional<Entrega> buscarPorId(long id);

    void save(Entrega entrega);
}
