package com.lucas.sistema.entrega.modules.historicoentrega.application.controller;

import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.historicoentrega.application.dto.HistoricoEntregaResponse;
import com.lucas.sistema.entrega.modules.historicoentrega.application.port.HistoricoEntregaMapper;
import com.lucas.sistema.entrega.modules.historicoentrega.application.port.HistoricoEntregaService;
import com.lucas.sistema.entrega.view.port.HistoricoEntregaController;

import java.util.List;

public class HistoricoEntregaControllerAdapter implements HistoricoEntregaController {

    private final HistoricoEntregaService historicoEntregaService;
    private final HistoricoEntregaMapper historicoEntregaMapper;


    public HistoricoEntregaControllerAdapter(HistoricoEntregaService historicoEntregaService, HistoricoEntregaMapper historicoEntregaMapper) {
        this.historicoEntregaService = historicoEntregaService;
        this.historicoEntregaMapper = historicoEntregaMapper;
    }

    @Override
    public HistoricoEntregaResponse adicionar(HistoricoEntregaAdicionarRequest historicoEntregaAdicionarRequest){
        var historicoEntrega = historicoEntregaMapper.toEntity(historicoEntregaAdicionarRequest);

        historicoEntregaService.adicionar(historicoEntrega);

        return historicoEntregaMapper.toResponse(historicoEntrega);

    }

    @Override
    List<HistoricoEntregaResponse> pegarEventos(){
        var eventos = historicoEntregaService.pegarEventos();

        return eventos.stream().map(historicoEntregaMapper::toResponse).toList();
    }


}
