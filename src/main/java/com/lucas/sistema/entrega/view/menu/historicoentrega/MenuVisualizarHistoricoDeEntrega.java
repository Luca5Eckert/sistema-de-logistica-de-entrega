package com.lucas.sistema.entrega.view.menu.historicoentrega;

import com.lucas.sistema.entrega.modulo.historicoentrega.application.dto.EventoEntregaResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.HistoricoEntregaController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;
import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuVisualizarHistoricoDeEntrega extends Menu {

    private final HistoricoEntregaController historicoEntregaController;

    protected MenuVisualizarHistoricoDeEntrega(Leitor leitor, HistoricoEntregaController historicoEntregaController) {
        super(leitor);
        this.historicoEntregaController = historicoEntregaController;
    }

    @Override
    public void executarMenu() {
        var idEntrega = chamarMenu();

        if(idEntrega == 0) {
            imprimir("OPERAÇÃO CANCELADA");
            setProximoMenu(new MenuHistoricoEntrega(getLeitor()));
            return;
        }

        var historicoEntrega = historicoEntregaController.pegarHistoricoDeEntrega(idEntrega);

        exibirHistorico(historicoEntrega, idEntrega);

        setProximoMenu(new MenuHistoricoEntrega(getLeitor()));


    }

    private void exibirHistorico(List<EventoEntregaResponse> historicoEntrega, long idEntrega) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                     HISTORICO DA ENTREGA " + idEntrega );
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(historicoEntrega);

        System.out.println("------------------------------------------------------------------------------");

    }

    private long chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                           HISTORICO DE ENTREGA                               ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" Digite o id da entrega ( 0 para cancelar ) : ");
        long idEntrega = getLeitor().nextLong();

        System.out.println("------------------------------------------------------------------------------");

        return idEntrega;

    }

}
