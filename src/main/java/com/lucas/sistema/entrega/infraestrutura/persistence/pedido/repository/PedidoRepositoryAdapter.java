package com.lucas.sistema.entrega.infraestrutura.persistence.pedido.repository;

import com.lucas.sistema.entrega.infraestrutura.persistence.pedido.dao.PedidoDao;
import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;
import com.lucas.sistema.entrega.modules.pedido.domain.port.PedidoRepository;
import java.util.Map;
import java.util.Optional;

public class PedidoRepositoryAdapter implements PedidoRepository {

    private final PedidoDao pedidoDAO;

    public PedidoRepositoryAdapter(PedidoDao pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    @Override
    public void adicionar(Pedido pedido) {
        pedidoDAO.adicionar(pedido);
    }

    @Override
    public Optional<Pedido> buscar(long pedidoId) {
        return pedidoDAO.buscar(pedidoId);
    }

    @Override
    public void salvar(Pedido pedido) {
        pedidoDAO.salvar(pedido);
    }

    @Override
    public Map<String, Long> pegarQuantidadePedidosPendentesPorEstado() {
        return pedidoDAO.pegarQuantidadePedidosPendentesPorEstado();
    }

    @Override
    public boolean existePorId(long pedidoId) {
        return buscar(pedidoId).isPresent();
    }
}