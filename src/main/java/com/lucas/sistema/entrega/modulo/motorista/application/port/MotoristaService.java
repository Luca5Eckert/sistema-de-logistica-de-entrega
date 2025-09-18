package com.lucas.sistema.entrega.modulo.motorista.application.port;

import com.lucas.sistema.entrega.modulo.motorista.domain.Motorista;

import java.util.List;

public interface MotoristaService {

    void cadastrar(Motorista motorista);

    void excluirPorId(long id);

    List<Motorista> pegarMotoristas();

    Motorista buscarPeloId(long id);
}
