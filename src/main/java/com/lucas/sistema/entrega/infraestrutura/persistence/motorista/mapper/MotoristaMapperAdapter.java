package com.lucas.sistema.entrega.infraestrutura.persistence.motorista.mapper;

import com.lucas.sistema.entrega.modulo.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.modulo.motorista.application.dto.MotoristaResponse;
import com.lucas.sistema.entrega.modulo.motorista.application.port.MotoristaMapper;
import com.lucas.sistema.entrega.modulo.motorista.domain.Motorista;

public class MotoristaMapperAdapter implements MotoristaMapper {

    @Override
    public Motorista toEntity(MotoristaAdicionarRequest motoristaAdicionarRequest) {
        return new Motorista(motoristaAdicionarRequest.nome(), motoristaAdicionarRequest.cnh(), motoristaAdicionarRequest.veiculo(), motoristaAdicionarRequest.cidadeBase());
    }

    @Override
    public MotoristaResponse toResponse(Motorista motorista) {
        return new MotoristaResponse(motorista.getId(), motorista.getNome(), motorista.getCnh(), motorista.getVeiculo(), motorista.getCidadeBase());
    }

}
