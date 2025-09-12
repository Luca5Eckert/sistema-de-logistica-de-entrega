package com.lucas.sistema.entrega.infraestrutura.persistence.cliente.repository;

import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.dao.ClienteDao;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;

import java.util.Optional;

public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteDao clienteDao;

    public ClienteRepositoryAdapter(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public void adicionar(Cliente cliente) {
        clienteDao.adicionar(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(long id) {
        return clienteDao.buscarPorId(id);
    }

    @Override
    public boolean buscarEntregaDependente(long id) {
        return clienteDao.buscarEntregaDependente(id);
    }

    @Override
    public boolean buscarPedidoDependente(long id) {
        return clienteDao.buscarPedidoDependente(id);
    }

    @Override
    public void excluirPorId(long id) {
        clienteDao.excluirPorId(id);
    }
}
