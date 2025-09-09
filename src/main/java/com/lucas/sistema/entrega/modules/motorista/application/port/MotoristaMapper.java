package com.lucas.sistema.entrega.modules.motorista.application.port;

import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaResponse;
import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;

public interface MotoristaMapper {
    Motorista toEntity(MotoristaAdicionarRequest motoristaAdicionarRequest);

    MotoristaResponse toResponse(Motorista motorista);
}
