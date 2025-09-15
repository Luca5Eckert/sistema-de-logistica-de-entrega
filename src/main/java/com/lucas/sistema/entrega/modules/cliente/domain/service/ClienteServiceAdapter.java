package com.lucas.sistema.entrega.modules.cliente.domain.service;

import com.lucas.sistema.entrega.infraestrutura.validador.LocationType;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.ClienteDependenciaException;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.localizacao.LocalizacaoCidadeInvalidaException;
import com.lucas.sistema.entrega.modules.cliente.domain.exceptions.localizacao.LocalizacaoEstadoInvalidaException;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ValidadorLocalizacao;

import java.util.List;

public class ClienteServiceAdapter implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ValidadorLocalizacao validadorLocalizacao;

    public ClienteServiceAdapter(ClienteRepository clienteRepository, ValidadorLocalizacao validadorLocalizacao) {
        this.clienteRepository = clienteRepository;
        this.validadorLocalizacao = validadorLocalizacao;
    }

    @Override
    public void adicionar(Cliente cliente) {
        validarLocalizacao(cliente.getCidade(), cliente.getEstado());

        clienteRepository.adicionar(cliente);

    }

    private void validarLocalizacao(String cidade, String estado) {
        if(!validadorLocalizacao.validarLocalizacao(LocationType.ESTADO, estado, null)) throw new LocalizacaoCidadeInvalidaException("Cidade não é valida");

        if(!validadorLocalizacao.validarLocalizacao(LocationType.CIDADE, cidade, estado)) throw new LocalizacaoEstadoInvalidaException("Estado não é valido");

    }

    @Override
    public void excluir(long id) {
        if(clienteRepository.buscarEntregaDependente(id)) throw new ClienteDependenciaException("Não é possível deletar um cliente que possui uma entrega dependente a ele");

        if(clienteRepository.buscarPedidoDependente(id)) throw new ClienteDependenciaException("Não é possível deletar um cliente que possui uma entrega dependente a ele");

        clienteRepository.excluirPorId(id);

    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.listar();
    }

}
