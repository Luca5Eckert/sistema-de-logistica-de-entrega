package com.lucas.sistema.entrega.modules.cliente.domain.service;

import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.mapper.ClienteMapper;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.ClienteDependenciaException;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.ClienteNullException;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.localizacao.LocalizacaoCidadeInvalidaException;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.localizacao.LocalizacaoEstadoInvalidaException;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ValidadorLocalizacao;

public class ClienteServiceAdapter implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ValidadorLocalizacao validadorLocalizacao;

    public ClienteServiceAdapter(ClienteRepository clienteRepository, ValidadorLocalizacao validadorLocalizacao) {
        this.clienteRepository = clienteRepository;
        this.validadorLocalizacao = validadorLocalizacao;
    }

    @Override
    public void adicionar(Cliente cliente) {
        validaLocalizacao(cliente.getCidade(), cliente.getEstado());

        clienteRepository.adicionar(cliente);

    }

    private void validaLocalizacao(String cidade, String estado) {
        if(validadorLocalizacao.valida(cidade)) throw new LocalizacaoCidadeInvalidaException("Cidade não é valida");

        if(validadorLocalizacao.valida(estado)) throw new LocalizacaoEstadoInvalidaException("Estado não é valido");

    }

    @Override
    public void excluir(long id) {
        if(clienteRepository.buscarEntregaDependente(id)) throw new ClienteDependenciaException("Não é possível deletar um cliente que possui uma entrega dependente a ele");

        if(clienteRepository.buscarPedidoDependente(id)) throw new ClienteDependenciaException("Não é possível deletar um cliente que possui uma entrega dependente a ele");

        clienteRepository.excluirPorId(id);

    }

}
