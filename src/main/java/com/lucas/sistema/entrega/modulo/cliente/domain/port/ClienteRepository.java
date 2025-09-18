package com.lucas.sistema.entrega.modulo.cliente.domain.port;

import com.lucas.sistema.entrega.modulo.cliente.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    void adicionar(Cliente cliente);

    Optional<Cliente> buscarPorId(long id);

    boolean buscarEntregaDependente(long id);

    boolean buscarPedidoDependente(long id);

    void excluirPorId(long id);

    List<Cliente> listar();
}
