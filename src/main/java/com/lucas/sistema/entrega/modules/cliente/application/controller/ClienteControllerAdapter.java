package com.lucas.sistema.entrega.modules.cliente.application.controller;


import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteExcluirRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteMapper;
import com.lucas.sistema.entrega.view.port.ClienteController;

import java.util.List;

public class ClienteControllerAdapter implements ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;


    public ClienteControllerAdapter(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest){
        var cliente = clienteMapper.toEntity(clienteAdicionarRequest);

        clienteService.adicionar(cliente);

        return clienteMapper.toResponse(cliente);
    }

    @Override
    public void excluir(ClienteExcluirRequest clienteExcluirRequest){
        clienteService.excluir(clienteExcluirRequest.id());
    }

    @Override
    public List<ClienteResponse> listar() {
        var clientes = clienteService.listar();
        return clientes.stream().map(clienteMapper::toResponse).toList();
    }

    @Override
    public ClienteResponse buscarPeloID(long id) {
        var cliente = clienteService.buscarPeloId(id);
        return clienteMapper.toResponse(cliente);
    }


}
