package com.lucas.sistema.entrega.infraestrutura.utils.beans;


import com.lucas.sistema.entrega.infraestrutura.persistence.motorista.dao.MotoristaDao;
import com.lucas.sistema.entrega.infraestrutura.persistence.motorista.mapper.MotoristaMapperAdapter;
import com.lucas.sistema.entrega.infraestrutura.persistence.motorista.repository.MotoristaRepositoryAdapter;
import com.lucas.sistema.entrega.modules.motorista.application.controller.MotoristaControllerAdapter;
import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaMapper;
import com.lucas.sistema.entrega.modules.motorista.application.port.MotoristaService;
import com.lucas.sistema.entrega.modules.motorista.domain.port.MotoristaRepository;
import com.lucas.sistema.entrega.modules.motorista.domain.service.MotoristaServiceAdapter;

public class MotoristaBeansUtil {

    private final static MotoristaDao MOTORISTA_DAO = new MotoristaDao();
    private final static MotoristaRepository MOTORISTA_REPOSITORY = new MotoristaRepositoryAdapter(MOTORISTA_DAO);
    private final static MotoristaService MOTORISTA_SERVICE = new MotoristaServiceAdapter(MOTORISTA_REPOSITORY);
    private final static MotoristaMapper MOTORISTA_MAPPER = new MotoristaMapperAdapter();
    private final static MotoristaControllerAdapter MOTORISTA_CONTROLLER = new MotoristaControllerAdapter(MOTORISTA_SERVICE, MOTORISTA_MAPPER);


    public static MotoristaControllerAdapter toInstanceController(){
        return MOTORISTA_CONTROLLER;
    }

    public static MotoristaRepository toInstanceRepository() {
        return MOTORISTA_REPOSITORY;
    }
}
