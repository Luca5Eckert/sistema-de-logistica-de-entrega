package com.lucas.sistema.entrega.modules.historicoentrega.domain.service;

import com.lucas.sistema.entrega.modules.historicoentrega.application.port.HistoricoEntregaService;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.port.HistoricoEntregaRepository;

public class HistoricoEntregaServiceAdapter implements HistoricoEntregaService {

    private final HistoricoEntregaRepository historicoEntregaRepository;

    public HistoricoEntregaServiceAdapter(HistoricoEntregaRepository historicoEntregaRepository) {
        this.historicoEntregaRepository = historicoEntregaRepository;
    }

    @Override
    public void adicionar(HistoricoEntrega historicoEntrega) {
        historicoEntregaRepository.adicionar(historicoEntrega);
    }
}
