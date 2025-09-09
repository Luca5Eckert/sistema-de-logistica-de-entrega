package com.lucas.sistema.entrega.modules.cliente.application.port;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;

public interface ClienteService {
    ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest);
}
