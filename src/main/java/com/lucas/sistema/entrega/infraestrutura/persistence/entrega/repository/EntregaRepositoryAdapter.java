package com.lucas.sistema.entrega.infraestrutura.persistence.entrega.repository;

import com.lucas.sistema.entrega.infraestrutura.persistence.entrega.dao.EntregaDao;
import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteEntregaResponse;
import com.lucas.sistema.entrega.modulo.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modulo.entrega.domain.port.EntregaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EntregaRepositoryAdapter implements EntregaRepository {

    private final EntregaDao entregaDao;

    public EntregaRepositoryAdapter(EntregaDao entregaDao) {
        this.entregaDao = entregaDao;
    }

    @Override
    public void adicionar(Entrega entrega) {
        entregaDao.adicionar(entrega);
    }

    @Override
    public Optional<Entrega> buscarPorId(long id) {
        return entregaDao.buscarPorId(id);
    }

    @Override
    public void save(Entrega entrega) {
        entregaDao.save(entrega);
    }

    @Override
    public Optional<List<Entrega>> pegarTodas() {
        return entregaDao.pegarTodas();
    }

    @Override
    public long pegarQuantidadeEntregaPorMotorista(long idMotorista) {
        return entregaDao.pegarQuantidadeEntregaPorMotorista(idMotorista);
    }

    @Override
    public List<ClienteEntregaResponse> pegarClientesComMaiorQuantidadeEntregas() {
        return entregaDao.pegarClientesComMaiorQuantidadeEntregas();
    }

    @Override
    public void excluirPorId(long id) {
        entregaDao.excluirPorId(id);
    }

    @Override
    public Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade() {
        return entregaDao.pegarQuantidadeEntregasPendentesPorCidade();
    }
}
