package com.lucas.sistema.entrega.modules.entrega.application.controller;

import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaAtualizarStatusRequest;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaResponse;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaMapper;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;

public class EntregaController {

    private final EntregaService entregaService;
    private final EntregaMapper entregaMapper;

    public EntregaController(EntregaService entregaService, EntregaMapper entregaMapper) {
        this.entregaService = entregaService;
        this.entregaMapper = entregaMapper;
    }

    public EntregaResponse adicionar(EntregaAdicionarRequest entregaAdicionarRequest){
        var entrega = entregaMapper.toEntity(entregaAdicionarRequest);

        entregaService.adicionar(entrega);

        return entregaMapper.toResponse(entrega);

    }

    public EntregaResponse atualizarStatus(EntregaAtualizarStatusRequest entregaAtualizarStatusRequest){
        var entrega = entregaService.atualizarStatus(entregaAtualizarStatusRequest.idEntrega(), entregaAtualizarStatusRequest.novoStatus());

        return entregaMapper.toResponse(entrega);
    }


}
