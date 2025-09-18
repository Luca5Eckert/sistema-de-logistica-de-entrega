package com.lucas.sistema.entrega.modulo.cliente.application.port;

import com.lucas.sistema.entrega.modulo.cliente.domain.Cliente;

import java.util.List;

public interface ClienteService {
    void adicionar(Cliente cliente);

    void excluir(long id);

    List<Cliente> listar();

    Cliente buscarPeloId(long id);
}
