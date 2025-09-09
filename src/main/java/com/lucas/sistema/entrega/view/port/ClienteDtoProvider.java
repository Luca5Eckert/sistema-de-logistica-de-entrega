package com.lucas.sistema.entrega.view.port;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;

public interface ClienteDtoProvider {
    ClienteAdicionarRequest criarDtoCriarCliente(String nome, String cpfCnpj, String cidade, String estado);
}
