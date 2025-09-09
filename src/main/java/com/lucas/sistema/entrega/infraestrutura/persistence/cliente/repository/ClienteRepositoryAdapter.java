package com.lucas.sistema.entrega.infraestrutura.persistence.cliente.repository;

import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.dao.ClienteDao;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;

public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteDao clienteDao;

    public ClienteRepositoryAdapter(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

}
