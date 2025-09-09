package com.lucas.sistema.entrega.modules.cliente.domain.port;

import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;

public interface ClienteRepository {
    void adicionar(Cliente cliente);
}
