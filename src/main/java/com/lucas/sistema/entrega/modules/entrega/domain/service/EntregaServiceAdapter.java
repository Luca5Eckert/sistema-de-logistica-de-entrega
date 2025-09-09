package com.lucas.sistema.entrega.modules.entrega.domain.service;

import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaNullException;
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
}
