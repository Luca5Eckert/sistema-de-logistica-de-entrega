package com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.repository;

import com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.dao.HistoricoEntregaDao;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.port.HistoricoEntregaRepository;

import java.util.List;

public class HistoricoEntregaRepositoryAdapter implements HistoricoEntregaRepository {

    private final HistoricoEntregaDao historicoEntregaDao;

    public HistoricoEntregaRepositoryAdapter(HistoricoEntregaDao historicoEntregaDao) {
        this.historicoEntregaDao = historicoEntregaDao;
    }

    @Override
    public void adicionar(HistoricoEntrega historicoEntrega) {
        historicoEntregaDao.adicionar(historicoEntrega);
    }

    @Override
    public List<HistoricoEntrega> pegarEventos() {
       return historicoEntregaDao.pegarEventos();
    }

    @Override
    public Object pegarHistoricoDeEntrega(long idEntrega) {
        return historicoEntregaDao.pegarHistoricoDeEntrega(idEntrega);
    }
}
