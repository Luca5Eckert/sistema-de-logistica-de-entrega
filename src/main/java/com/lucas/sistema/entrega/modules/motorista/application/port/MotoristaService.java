package com.lucas.sistema.entrega.modules.motorista.application.port;

import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

public interface MotoristaService {

    void cadastrar(Motorista motorista);

    void excluirPorId(long id);
}
