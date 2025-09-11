package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteExcluirRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;

public interface ClienteController {
    ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest);

    void excluir(ClienteExcluirRequest clienteExcluirRequest);

}
