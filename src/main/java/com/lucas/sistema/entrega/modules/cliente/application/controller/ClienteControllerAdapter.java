package com.lucas.sistema.entrega.modules.cliente.application.controller;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.view.port.ClienteController;

public class ClienteControllerAdapter implements ClienteController {

    private final ClienteService clienteService;

    public ClienteControllerAdapter(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest){
        return clienteService.adicionar(clienteAdicionarRequest);
    }
}
