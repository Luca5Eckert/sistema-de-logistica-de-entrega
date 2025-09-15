package com.lucas.sistema.entrega.modules.cliente.application.port;

import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;

import java.util.List;

public interface ClienteService {
    void adicionar(Cliente cliente);

    void excluir(long id);

    List<Cliente> listar();
}
