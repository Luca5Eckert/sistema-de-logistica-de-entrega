package com.lucas.sistema.entrega.infraestrutura.utils.beans;

import com.lucas.sistema.entrega.infraestrutura.persistence.entrega.dao.EntregaDao;
import com.lucas.sistema.entrega.infraestrutura.persistence.entrega.mapper.EntregaMapperAdapter;
import com.lucas.sistema.entrega.infraestrutura.persistence.entrega.repository.EntregaRepositoryAdapter;
import com.lucas.sistema.entrega.modules.entrega.application.controller.EntregaControllerAdapter;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaMapper;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;
import com.lucas.sistema.entrega.modules.entrega.domain.port.EntregaRepository;
import com.lucas.sistema.entrega.modules.entrega.domain.service.EntregaServiceAdapter;

public class EntregaBeansUtil {

    private final static EntregaDao ENTREGA_DAO = new EntregaDao();
    private final static EntregaRepository ENTREGA_REPOSITORY = new EntregaRepositoryAdapter(ENTREGA_DAO);
    private final static EntregaService ENTREGA_SERVICE = new EntregaServiceAdapter(ENTREGA_REPOSITORY);
    private final static EntregaMapper ENTREGA_MAPPER = new EntregaMapperAdapter();
    private final static EntregaControllerAdapter ENTREGA_CONTROLLER = new EntregaControllerAdapter(ENTREGA_SERVICE, ENTREGA_MAPPER, ClienteBeansUtil.toInstanceMapper());


    public static EntregaControllerAdapter toInstanceController(){
        return ENTREGA_CONTROLLER;
    }
    
}
