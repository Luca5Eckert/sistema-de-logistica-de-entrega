package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaAdicionarRequest;
import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaDeletarRequest;
import com.lucas.sistema.entrega.modules.motorista.application.dto.MotoristaResponse;

public interface MotoristaController {

    public MotoristaResponse cadastrar(MotoristaAdicionarRequest motoristaAdicionarRequest);

    public void excluir(MotoristaDeletarRequest motoristaDeletarRequest);

}
