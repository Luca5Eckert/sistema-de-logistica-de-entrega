package com.lucas.sistema.entrega.modules.cliente.domain.service;

import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.mapper.ClienteMapper;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;

public class ClienteServiceAdapter implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest) {
        Cliente cliente = clienteMapper.toEntity(clienteAdicionarRequest);

        clienteRepository.adicionar(cliente);

        return clienteMapper.toResponse(cliente);
    }

}
