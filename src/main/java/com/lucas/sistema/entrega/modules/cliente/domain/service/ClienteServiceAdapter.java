package com.lucas.sistema.entrega.modules.cliente.domain.service;

import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.mapper.ClienteMapper;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.localizacao.LocalizacaoCidadeInvalidaException;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.localizacao.LocalizacaoEstadoInvalidaException;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ValidadorLocalizacao;

public class ClienteServiceAdapter implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final ValidadorLocalizacao validadorLocalizacao;

    public ClienteServiceAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper, ValidadorLocalizacao validadorLocalizacao) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.validadorLocalizacao = validadorLocalizacao;
    }

    @Override
    public ClienteResponse adicionar(ClienteAdicionarRequest clienteAdicionarRequest) {
        validaLocalizacao(clienteAdicionarRequest.cidade(), clienteAdicionarRequest.estado());

        Cliente cliente = clienteMapper.toEntity(clienteAdicionarRequest);

        clienteRepository.adicionar(cliente);

        return clienteMapper.toResponse(cliente);
    }

    private void validaLocalizacao(String cidade, String estado) {
        if(validadorLocalizacao.valida(cidade)) throw new LocalizacaoCidadeInvalidaException("Cidade não é valida");

        if(validadorLocalizacao.valida(estado)) throw new LocalizacaoEstadoInvalidaException("Estado não é valido");

    }

}
