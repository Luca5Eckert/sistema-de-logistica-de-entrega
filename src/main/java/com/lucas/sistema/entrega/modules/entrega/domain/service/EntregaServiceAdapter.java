package com.lucas.sistema.entrega.modules.entrega.domain.service;

import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.entrega.application.port.EntregaService;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaExclusaoException;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaNullException;
import com.lucas.sistema.entrega.modules.entrega.domain.exceptions.EntregaStatusNullException;
import com.lucas.sistema.entrega.modules.entrega.domain.port.EntregaRepository;

import java.util.List;

public class EntregaServiceAdapter implements EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaServiceAdapter(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public void adicionar(Entrega entrega) {
        if(entrega == null){
            throw new EntregaNullException("A entrega não pode ser nula");
        }

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
        return entregaRepository.pegarQuantidadeEntregaPorMotorista();
    }

    @Override
    public List<Cliente> pegarClientesComMaiorQuantidadeEntregas(){
        return entregaRepository.pegarClientesComMaiorQuantidadeEntregas();
    }

    @Override
    public void excluirEntrega(long id) {
        var entrega = entregaRepository.buscarPorId(id).orElseThrow(() -> new EntregaNullException("Não foi encontrada nenhuma entrega disponível"));

        if(entrega.validarExclusao()) throw new EntregaExclusaoException("Entrega só pode ser excluida se for atrasada");

        entregaRepository.excluirPorId(id);
    }

}
