package com.lucas.sistema.entrega.infraestrutura.utils.beans;

import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.dao.ClienteDao;
import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.mapper.ClienteMapperAdapter;
import com.lucas.sistema.entrega.infraestrutura.persistence.cliente.repository.ClienteRepositoryAdapter;
import com.lucas.sistema.entrega.infraestrutura.validador.ValidadorLocalizacaoAdapter;
import com.lucas.sistema.entrega.modules.cliente.application.controller.ClienteControllerAdapter;
import com.lucas.sistema.entrega.modules.cliente.application.port.ClienteService;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteMapper;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ClienteRepository;
import com.lucas.sistema.entrega.modules.cliente.domain.port.ValidadorLocalizacao;
import com.lucas.sistema.entrega.modules.cliente.domain.service.ClienteServiceAdapter;
import com.lucas.sistema.entrega.view.port.ClienteController;

public class ClienteBeansUtil {

    private final static ClienteDao CLIENTE_DAO = new ClienteDao();
    private final static ClienteRepository CLIENTE_REPOSITORY = new ClienteRepositoryAdapter(CLIENTE_DAO);
    private final static ValidadorLocalizacao VALIDADOR_LOCALIZACAO = new ValidadorLocalizacaoAdapter();
    private final static ClienteService CLIENTE_SERVICE = new ClienteServiceAdapter(CLIENTE_REPOSITORY, VALIDADOR_LOCALIZACAO);
    private final static ClienteMapper CLIENTE_MAPPER = new ClienteMapperAdapter();
    private final static ClienteController CLIENTE_CONTROLLER = new ClienteControllerAdapter(CLIENTE_SERVICE, CLIENTE_MAPPER);


    public static ClienteController toInstanceController(){
        return CLIENTE_CONTROLLER;
    }

    public static ClienteMapper toInstanceMapper() {
        return CLIENTE_MAPPER;
    }
}
