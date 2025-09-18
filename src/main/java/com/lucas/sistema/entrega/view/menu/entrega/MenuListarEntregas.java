package com.lucas.sistema.entrega.view.menu.entrega;

import com.lucas.sistema.entrega.modules.entrega.application.dto.EntregaResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.EntregaController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuListarEntregas extends Menu {

    private final EntregaController entregaController;

    public MenuListarEntregas(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }


    @Override
    public void executarMenu() {
        var entregas = entregaController.pegarEntregas();

        chamarMenu(entregas);

        setProximoMenu(new MenuEntrega(getLeitor()));
    }

    private void chamarMenu(List<EntregaResponse> entregas) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              LISTAR ENTREGAS                                 ");
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(entregas);

        System.out.println("------------------------------------------------------------------------------");


    }

}
