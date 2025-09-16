package com.lucas.sistema.entrega.modules.motorista.application.port;

import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

import java.util.List;

public interface MotoristaService {

    void cadastrar(Motorista motorista);

    void excluirPorId(long id);

    List<Motorista> pegarMotoristas();
}
