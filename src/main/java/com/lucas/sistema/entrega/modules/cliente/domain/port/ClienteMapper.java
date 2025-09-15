package com.lucas.sistema.entrega.modules.cliente.domain.port;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;

public interface ClienteMapper {

    public Cliente toEntity(ClienteAdicionarRequest clienteAdicionarRequest);

    public ClienteResponse toResponse(Cliente cliente);
}
