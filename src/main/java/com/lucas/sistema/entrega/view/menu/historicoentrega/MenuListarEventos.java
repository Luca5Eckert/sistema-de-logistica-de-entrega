package com.lucas.sistema.entrega.view.menu.historicoentrega;

import com.lucas.sistema.entrega.modulo.historicoentrega.application.dto.HistoricoEntregaResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.HistoricoEntregaController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuListarEventos extends Menu {

    private final HistoricoEntregaController historicoEntregaController;

    protected MenuListarEventos(Leitor leitor, HistoricoEntregaController historicoEntregaController) {
        super(leitor);
        this.historicoEntregaController = historicoEntregaController;
    }

    @Override
    public void executarMenu() {
        var eventos = historicoEntregaController.pegarEventos();

        chamarMenu(eventos);

        setProximoMenu(new MenuHistoricoEntrega(getLeitor()));
    }

    private void chamarMenu(List<HistoricoEntregaResponse> eventos) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              LISTAR EVENTO                                   ");
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(eventos);

        System.out.println("------------------------------------------------------------------------------");

    }


}
