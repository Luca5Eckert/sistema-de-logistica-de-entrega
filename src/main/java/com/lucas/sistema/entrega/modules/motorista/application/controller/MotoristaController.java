package com.lucas.sistema.entrega.modules.motorista.application.controller;

import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaResponse;
import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaMapper;
import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaService;

public class MotoristaController {

    private final MotoristaService motoristaService;
    private final MotoristaMapper motoristaMapper;

    public MotoristaController(MotoristaService motoristaService, MotoristaMapper motoristaMapper) {
        this.motoristaService = motoristaService;
        this.motoristaMapper = motoristaMapper;
    }

    public MotoristaResponse cadastrar(MotoristaAdicionarRequest motoristaAdicionarRequest){
        var motorista = motoristaMapper.toEntity(motoristaAdicionarRequest);

        motoristaService.cadastrar(motorista);

        return motoristaMapper.toResponse(motorista);
    }
}
