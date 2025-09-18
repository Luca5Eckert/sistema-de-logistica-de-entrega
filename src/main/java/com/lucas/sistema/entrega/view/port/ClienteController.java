package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteExcluirRequest;
import com.lucas.sistema.entrega.modulo.cliente.application.dto.ClienteResponse;

import java.util.List;

public interface ClienteController {
    ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest);

    void excluir(ClienteExcluirRequest clienteExcluirRequest);

    List<ClienteResponse> listar();

    ClienteResponse buscarPeloID(long id);
}
