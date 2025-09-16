package com.lucas.sistema.entrega.infraestrutura.utils.beans;

import com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.dao.HistoricoEntregaDao;
import com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.mapper.HistoricoEntregaMapperAdapter;
import com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.repository.HistoricoEntregaRepositoryAdapter;
import com.lucas.sistema.entrega.modules.historicoentrega.application.controller.HistoricoEntregaControllerAdapter;
import com.lucas.sistema.entrega.modules.historicoentrega.application.port.HistoricoEntregaMapper;
import com.lucas.sistema.entrega.modules.historicoentrega.application.port.HistoricoEntregaService;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.port.HistoricoEntregaRepository;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.service.HistoricoEntregaServiceAdapter;

public class HistoricoEntregaBeansUtil {

    private final static HistoricoEntregaDao HISTORICO_ENTREGA_DAO = new HistoricoEntregaDao();
    private final static HistoricoEntregaRepository HISTORICO_ENTREGA_REPOSITORY = new HistoricoEntregaRepositoryAdapter(HISTORICO_ENTREGA_DAO);
    private final static HistoricoEntregaService HISTORICO_ENTREGA_SERVICE = new HistoricoEntregaServiceAdapter(HISTORICO_ENTREGA_REPOSITORY);
    private final static HistoricoEntregaMapper HISTORICO_ENTREGA_MAPPER = new HistoricoEntregaMapperAdapter();
    private final static HistoricoEntregaControllerAdapter HISTORICO_ENTREGA_CONTROLLER = new HistoricoEntregaControllerAdapter(HISTORICO_ENTREGA_SERVICE, HISTORICO_ENTREGA_MAPPER);


    public static HistoricoEntregaControllerAdapter toInstanceController(){
        return HISTORICO_ENTREGA_CONTROLLER;
    }
    
}
