package com.lucas.sistema.entrega.modules.motorista.application.controller;

import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaDeletarRequest;
import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaResponse;
import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaMapper;
import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaService;
import com.lucas.sistema.entrega.view.port.MotoristaController;

import java.util.List;

public class MotoristaControllerAdapter implements MotoristaController {

    private final MotoristaService motoristaService;
    private final MotoristaMapper motoristaMapper;

    public MotoristaControllerAdapter(MotoristaService motoristaService, MotoristaMapper motoristaMapper) {
        this.motoristaService = motoristaService;
        this.motoristaMapper = motoristaMapper;
    }

    @Override
    public MotoristaResponse cadastrar(MotoristaAdicionarRequest motoristaAdicionarRequest){
        var motorista = motoristaMapper.toEntity(motoristaAdicionarRequest);

        motoristaService.cadastrar(motorista);

        return motoristaMapper.toResponse(motorista);
    }

    @Override
    public void excluir(MotoristaDeletarRequest motoristaDeletarRequest){
        motoristaService.excluirPorId(motoristaDeletarRequest.id());
    }

    @Override
    public List<MotoristaResponse> pegarMotoristas() {
        var motoristas = motoristaService.pegarMotoristas();
        return motoristas.stream().map(motoristaMapper::toResponse).toList();
    }

    @Override
    public MotoristaResponse buscarPeloID(long id) {
        var motorista = motoristaService.buscarPeloId(id);
        return motoristaMapper.toResponse(motorista);
    }

}
