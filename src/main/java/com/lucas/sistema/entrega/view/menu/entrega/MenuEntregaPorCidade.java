package com.lucas.sistema.entrega.view.menu.entrega;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.EntregaController;

import java.util.Map;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;
import static com.lucas.sistema.entrega.infraestrutura.utils.beans.EntregaBeansUtil.toInstanceController;

public class MenuEntregaPorCidade extends Menu {

    private final EntregaController entregaController;

    public MenuEntregaPorCidade(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }

    @Override
    public void executarMenu() {

        chamarMenu();

        setProximoMenu(new MenuEntrega(getLeitor()));
    }

    private void chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                 ENTREGAS PENDENTES POR CIDADE                                ");
        System.out.println("------------------------------------------------------------------------------");

        Map<String, Long> entregasPorCidade = entregaController.pegarQuantidadeEntregasPendentesPorCidade();

        if (entregasPorCidade.isEmpty()) {
            imprimir("| Não há entregas pendentes no momento.");
        } else {
            entregasPorCidade.forEach((cidade, quantidade) ->
                    imprimir("| " + cidade + ": " + quantidade + " entrega(s) pendente(s)")
            );
        }

        System.out.println("------------------------------------------------------------------------------");
    }
}