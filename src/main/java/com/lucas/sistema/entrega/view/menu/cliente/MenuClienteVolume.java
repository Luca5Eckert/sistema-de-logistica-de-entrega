package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.ClienteController;
import com.lucas.sistema.entrega.view.port.EntregaController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuClienteVolume extends Menu {

    private final EntregaController entregaController;

    public MenuClienteVolume(Leitor leitor, EntregaController entregaController) {
        super(leitor);
        this.entregaController = entregaController;
    }

    @Override
    public void executarMenu() {
        var clientes = entregaController.pegarClientesComMaiorQuantidadeEntregas();

        chamarMenu(clientes);
    }

    private void chamarMenu(List<ClienteResponse> clientes) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                    CLIENTES COM MAIOR VOLUME ENTREGA                         ");
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(clientes);

        System.out.println("------------------------------------------------------------------------------");


    }
}
