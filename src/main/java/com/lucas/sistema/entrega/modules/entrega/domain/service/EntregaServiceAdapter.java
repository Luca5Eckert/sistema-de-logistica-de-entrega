package com.lucas.sistema.entrega.modules.entrega.domain.service;

import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaNullException;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaStatusNullException;
import com.lucas.sistema.entrega.modules.entrega.domain.port.EntregaRepository;

public class EntregaServiceAdapter implements EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaServiceAdapter(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public void adicionar(Entrega entrega) {
        if(entrega == null){
            throw new EntregaNullException("A entrega não pode ser nula");
        }

        entregaRepository.adicionar(entrega);

    }

    @Override
    public Entrega atualizarStatus(long id, EntregaStatus entregaStatus) {

        if(entregaStatus == null) throw new EntregaStatusNullException("A entrega nova não pode ser nula");

        var entrega = entregaRepository.buscarPorId(id);

        if(entrega == null) throw new EntregaNullException("A entrega não pode ser vazia");

        entrega.validarMudancaDeStatus();

        entrega.setStatus(entregaStatus);

        entregaRepository.save(entrega);

        return entrega;

    }

}
