package com.lucas.sistema.entrega.modules.entrega.domain.port;

import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;

public interface EntregaRepository {

    void adicionar(Entrega entrega);

    Entrega buscarPorId(long id);

    void save(Entrega entrega);
}
