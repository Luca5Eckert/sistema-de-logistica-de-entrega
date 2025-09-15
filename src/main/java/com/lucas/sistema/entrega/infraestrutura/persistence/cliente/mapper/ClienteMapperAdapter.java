package com.lucas.sistema.entrega.infraestrutura.persistence.cliente.mapper;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteMapper;

public class ClienteMapperAdapter implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteAdicionarRequest clienteAdicionarRequest) {
        return new Cliente(clienteAdicionarRequest.nome(), clienteAdicionarRequest.cpfCnpj(), clienteAdicionarRequest.endereco(), clienteAdicionarRequest.cidade(), clienteAdicionarRequest.estado());
    }

    @Override
    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getCpfCnpj(), cliente.getEndereco(),  cliente.getCidade(), cliente.getEstado());
    }
}
