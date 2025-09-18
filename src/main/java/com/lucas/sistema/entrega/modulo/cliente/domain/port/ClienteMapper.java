package com.lucas.sistema.entrega.modulo.cliente.domain.port;

import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modulo.cliente.domain.Cliente;

public interface ClienteMapper {

    public Cliente toEntity(ClienteAdicionarRequest clienteAdicionarRequest);

    public ClienteResponse toResponse(Cliente cliente);
}
