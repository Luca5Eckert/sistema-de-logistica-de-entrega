package com.lucas.sistema.entrega.modules.motorista.domain.service;


import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaService;
import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;
import com.lucas.sistema.entrega.modules.motorista.domain.exception.MotoristaNullException;
import com.lucas.sistema.entrega.modules.motorista.domain.port.MotoristaRepository;

public class MotoristaServiceAdapter implements MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaServiceAdapter(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @Override
    public void cadastrar(Motorista motorista) {
        if(motorista == null){
            throw new MotoristaNullException("Não é possível adicionar um motorista nulo");
        }
        motoristaRepository.cadastrar(motorista);
    }
}
