package com.lucas.sistema.entrega.infraestrutura.utils.beans;

import com.lucas.sistema.entrega.infraestrutura.persistence.pedido.dao.PedidoDao;
import com.lucas.sistema.entrega.infraestrutura.persistence.pedido.mapper.PedidoMapperAdapter;
import com.lucas.sistema.entrega.infraestrutura.persistence.pedido.repository.PedidoRepositoryAdapter;
import com.lucas.sistema.entrega.modules.motorista.domain.port.MotoristaRepository;
import com.lucas.sistema.entrega.modules.pedido.application.controller.PedidoControllerAdapter;
import com.lucas.sistema.entrega.modules.pedido.application.port.PedidoMapper;
import com.lucas.sistema.entrega.modules.pedido.application.port.PedidoService;
import com.lucas.sistema.entrega.modules.pedido.domain.port.PedidoRepository;
import com.lucas.sistema.entrega.modules.pedido.domain.service.PedidoServiceAdapter;

public class PedidoBeansUtil {

    private final static PedidoDao PEDIDO_DAO = new PedidoDao();
    private final static PedidoRepository PEDIDO_REPOSITORY = new PedidoRepositoryAdapter(PEDIDO_DAO);
    private final static PedidoService PEDIDO_SERVICE = new PedidoServiceAdapter(PEDIDO_REPOSITORY, ClienteBeansUtil.toInstanceRepository());
    private final static PedidoMapper PEDIDO_MAPPER = new PedidoMapperAdapter();
    private final static PedidoControllerAdapter PEDIDO_CONTROLLER = new PedidoControllerAdapter(PEDIDO_SERVICE, PEDIDO_MAPPER);

    public static PedidoControllerAdapter toInstanceController(){
        return PEDIDO_CONTROLLER;
    }


    public static PedidoRepository toInstanceRepository() {
        return PEDIDO_REPOSITORY;
    }
}
