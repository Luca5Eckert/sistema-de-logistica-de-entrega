package com.lucas.sistema.entrega.modulo.historicoentrega.domain.service;

import com.lucas.sistema.entrega.modulo.entrega.domain.exceptions.EntregaNullException;
import com.lucas.sistema.entrega.modulo.entrega.domain.port.EntregaRepository;
import com.lucas.sistema.entrega.modulo.historicoentrega.application.port.HistoricoEntregaService;
import com.lucas.sistema.entrega.modulo.historicoentrega.domain.HistoricoEntrega;
import com.lucas.sistema.entrega.modulo.historicoentrega.domain.port.HistoricoEntregaRepository;

import java.util.List;

public class HistoricoEntregaServiceAdapter implements HistoricoEntregaService {

    private final HistoricoEntregaRepository historicoEntregaRepository;
    private final EntregaRepository entregaRepository;

    public HistoricoEntregaServiceAdapter(HistoricoEntregaRepository historicoEntregaRepository, EntregaRepository entregaRepository) {
        this.historicoEntregaRepository = historicoEntregaRepository;
        this.entregaRepository = entregaRepository;
    }

    @Override
    public void adicionar(HistoricoEntrega historicoEntrega) {

        entregaRepository.buscarPorId(historicoEntrega.getEntregaId()).orElseThrow(() -> new EntregaNullException(" Entrega não encontrado com id: " + historicoEntrega.getEntregaId()));

        historicoEntregaRepository.adicionar(historicoEntrega);
    }

    @Override
    public List<HistoricoEntrega> pegarEventos() {
        return historicoEntregaRepository.pegarEventos();
    }

    @Override
    public List<HistoricoEntrega> pegarHistoricoDeEntrega(long idEntrega) {

        entregaRepository.buscarPorId(idEntrega).orElseThrow(() -> new EntregaNullException(" Entrega não encontrado com id: " + idEntrega));

        return historicoEntregaRepository.pegarHistoricoDeEntrega(idEntrega);
    }

}
