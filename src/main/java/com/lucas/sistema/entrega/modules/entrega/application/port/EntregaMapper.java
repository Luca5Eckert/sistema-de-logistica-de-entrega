package com.lucas.sistema.entrega.modules.entrega.application.port;

import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaResponse;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;

public interface EntregaMapper {

    Entrega toEntity(EntregaAdicionarRequest entregaAdicionarRequest);

    EntregaResponse toResponse(Entrega entrega);

}
