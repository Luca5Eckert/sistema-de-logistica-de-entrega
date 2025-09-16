package com.lucas.sistema.entrega.infraestrutura.persistence.motorista.repository;

import com.lucas.sistema.entrega.infraestrutura.persistence.motorista.dao.MotoristaDao;
import com.lucas.sistema.entrega.modules.motorista.domain.port.MotoristaRepository;

import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

import java.util.List;

public class MotoristaRepositoryAdapter implements MotoristaRepository {

    private final MotoristaDao motoristaDao;

    public MotoristaRepositoryAdapter(MotoristaDao motoristaDao) {
        this.motoristaDao = motoristaDao;
    }

    @Override
    public void cadastrar(Motorista motorista) {
        motoristaDao.cadastrar(motorista);
    }

    @Override
    public boolean excluirPorId(long id) {
        return motoristaDao.excluirPorId(id);
    }

    @Override
    public boolean buscarEntregaDependente(long id) {
        return motoristaDao.buscarEntregaDependente(id);
    }

    @Override
    public boolean buscarPedidoDependente(long id) {
        return motoristaDao.buscarPedidoDependente(id);
    }

    @Override
    public boolean existePorId(long motoristaId) {
        return motoristaDao.existePorId(motoristaId);
    }

    @Override
    public List<Motorista> pegarMotoristas() {
        return motoristaDao.pegarMotoristas();
    }

    @Override
    public Motorista buscarPeloId(long id) {
        return motoristaDao.buscarPeloId(id);
    }
}