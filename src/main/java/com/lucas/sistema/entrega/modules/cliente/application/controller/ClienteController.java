package com.lucas.sistema.entrega.modules.cliente.application.controller;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest){
        return clienteService.adicionar(clienteAdicionarRequest);
    }
}
