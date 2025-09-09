package com.lucas.sistema.entrega.modules.motorista.domain.port;

import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

public interface MotoristaRepository {
    void cadastrar(Motorista motorista);
}
