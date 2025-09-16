package com.lucas.sistema.entrega.modules.entrega.application.controller;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteMapper;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaAdicionarRequest;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaAtualizarStatusRequest;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaExcluirRequest;
import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaResponse;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaMapper;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;
import com.lucas.sistema.entrega.view.port.EntregaController;

import java.util.List;
import java.util.Map;

public class EntregaControllerAdapter implements EntregaController {

    private final EntregaService entregaService;
    private final EntregaMapper entregaMapper;
    private final ClienteMapper clienteMapper;


    public EntregaControllerAdapter(EntregaService entregaService, EntregaMapper entregaMapper, ClienteMapper clienteMapper) {
        this.entregaService = entregaService;
        this.entregaMapper = entregaMapper;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public EntregaResponse adicionar(EntregaAdicionarRequest entregaAdicionarRequest){
        var entrega = entregaMapper.toEntity(entregaAdicionarRequest);

        entregaService.adicionar(entrega);

        return entregaMapper.toResponse(entrega);

    }

    @Override
    public void excluirEntrega(EntregaExcluirRequest entregaExcluirRequest){
        entregaService.excluirEntrega(entregaExcluirRequest.id());
    }

    @Override
    public EntregaResponse atualizarStatus(EntregaAtualizarStatusRequest entregaAtualizarStatusRequest){
        var entrega = entregaService.atualizarStatus(entregaAtualizarStatusRequest.idEntrega(), entregaAtualizarStatusRequest.novoStatus());

        return entregaMapper.toResponse(entrega);
    }

    @Override
    public List<EntregaResponse> pegarEntregas(){
        var lista = entregaService.pegarEntregas();

        return lista.stream().map(entregaMapper::toResponse).toList();
    }

    @Override
    public long pegarTotalEntregasPorMotorista(long idMotorista){
        return entregaService.pegarQuantidadeEntregasPorMotorista(idMotorista);
    }

    @Override
    public List<ClienteResponse> pegarClientesComMaiorQuantidadeEntregas() {
        var listaClientes = entregaService.pegarClientesComMaiorQuantidadeEntregas();

        return listaClientes.stream().map(clienteMapper::toResponse).toList();

    }

    @Override
    public Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade(){
        return entregaService.pegarQuantidadeEntregasPendentesPorCidade();
    }

    @Override
    public EntregaResponse pegarEntrega(long idEntrega) {
        var entrega =  entregaService.pegarEntrega(idEntrega);
        return entregaMapper.toResponse(entrega);
    }


}
