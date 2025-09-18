package com.lucas.sistema.entrega.modulo.motorista.application.port;

import com.lucas.sistema.entrega.modulo.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.modulo.motorista.application.dto.MotoristaResponse;
import com.lucas.sistema.entrega.modulo.motorista.domain.Motorista;

public interface MotoristaMapper {
    Motorista toEntity(MotoristaAdicionarRequest motoristaAdicionarRequest);

    MotoristaResponse toResponse(Motorista motorista);
}
