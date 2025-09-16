package com.lucas.sistema.entrega.modules.entrega.domain.service;

import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaException;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaExclusaoException;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaNullException;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaStatusNullException;
import com.lucas.sistema.entrega.modules.entrega.domain.port.EntregaRepository;
import com.lucas.sistema.entrega.modules.motorista.domain.exception.MotoristaException;
import com.lucas.sistema.entrega.modules.motorista.domain.port.MotoristaRepository;
import com.lucas.sistema.entrega.modules.pedido.domain.port.PedidoRepository;

import java.util.List;
import java.util.Map;

public class EntregaServiceAdapter implements EntregaService {

    private final EntregaRepository entregaRepository;
    private final MotoristaRepository motoristaRepository;
    private final PedidoRepository pedidoRepository;

    public EntregaServiceAdapter(EntregaRepository entregaRepository, MotoristaRepository motoristaRepository, PedidoRepository pedidoRepository) {
        this.entregaRepository = entregaRepository;
        this.motoristaRepository = motoristaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void adicionar(Entrega entrega) {
        if(entrega == null){
            throw new EntregaNullException("A entrega não pode ser nula");
        }

        if(!motoristaRepository.existePorId(entrega.getMotoristaId())) throw new EntregaException(" Não encontrado motorista com id: " + entrega.getMotoristaId());
        if(!pedidoRepository.existePorId(entrega.getPedidoId())) throw new EntregaException(" Não encontrado pedido com id: " + entrega.getPedidoId());

        entregaRepository.adicionar(entrega);

    }

    @Override
    public Entrega atualizarStatus(long id, EntregaStatus entregaStatus) {

        if(entregaStatus == null) throw new EntregaStatusNullException("O status da entrega nova não pode ser nula");

        var entrega = entregaRepository.buscarPorId(id).orElseThrow(() -> new EntregaNullException("Entrega não encontrada com o id: " + id));

        entrega.validarMudancaDeStatus();

        entrega.setStatus(entregaStatus);

        entregaRepository.save(entrega);

        return entrega;

    }

    @Override
    public List<Entrega> pegarEntregas() {
        return entregaRepository.pegarTodas().orElseThrow(() -> new EntregaNullException("Não foi encontrada nenhuma entrega disponível"));
    }

    @Override
    public long pegarQuantidadeEntregasPorMotorista(long idMotorista) {
        if(!motoristaRepository.existePorId(idMotorista)) throw new MotoristaException(" Motorista não encontrado com id: " + idMotorista);

        return entregaRepository.pegarQuantidadeEntregaPorMotorista(idMotorista);
    }

    @Override
    public List<Cliente> pegarClientesComMaiorQuantidadeEntregas(){
        return entregaRepository.pegarClientesComMaiorQuantidadeEntregas();
    }

    @Override
    public void excluirEntrega(long id) {
        var entrega = entregaRepository.buscarPorId(id).orElseThrow(() -> new EntregaNullException("Não foi encontrada nenhuma entrega disponível com o id: " + id));

        if(entrega.validarExclusao()) throw new EntregaExclusaoException("Entrega só pode ser excluida se for atrasada");

        entregaRepository.excluirPorId(id);
    }

    @Override
    public Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade() {
        return entregaRepository.pegarQuantidadeEntregasPendentesPorCidade();
    }

    @Override
    public Entrega pegarEntrega(long idEntrega) {
        return entregaRepository.buscarPorId(idEntrega).orElseThrow(() -> new EntregaNullException("Não foi encontrada nenhuma entrega disponível com o id: " + idEntrega));
    }

}
