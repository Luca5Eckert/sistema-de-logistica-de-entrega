package com.lucas.sistema.entrega.modules.motorista.domain.service;


import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaService;
import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;
import com.lucas.sistema.entrega.modules.motorista.domain.exception.MotoristaDependenciaException;
import com.lucas.sistema.entrega.modules.motorista.domain.exception.MotoristaNullException;
import com.lucas.sistema.entrega.modules.motorista.domain.port.MotoristaRepository;

import java.util.List;

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

    @Override
    public void excluirPorId(long id) {
        var deletou = motoristaRepository.excluirPorId(id);

        if(motoristaRepository.buscarEntregaDependente(id)) throw new MotoristaDependenciaException("Não é possível deletar um cliente que possui uma entrega dependente a ele");

        if(motoristaRepository.buscarPedidoDependente(id)) throw new MotoristaDependenciaException("Não é possível deletar um cliente que possui uma entrega dependente a ele");

        if(!deletou) throw new MotoristaNullException("Motorista não existe com id: " + id );
    }

    @Override
    public List<Motorista> pegarMotoristas() {
        return motoristaRepository.pegarMotoristas();
    }
}
