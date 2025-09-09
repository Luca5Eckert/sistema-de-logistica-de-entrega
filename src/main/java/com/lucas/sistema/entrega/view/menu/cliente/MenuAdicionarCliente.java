package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.modules.cliente.application.controller.ClienteController;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteAdicionarRequest;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;

public class MenuAdicionarCliente extends Menu<ClienteAdicionarRequest> {

    private final ClienteController controller;

    protected MenuAdicionarCliente(Leitor leitor, ClienteController controller) {
        super(leitor);
        this.controller = controller;
    }

    @Override
    public void chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              ADICIONAR CLIENTE                               ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" Nome do cliente: ");
        String nome = getLeitor().nextLine();

    }

    @Override
    public void executarMenu() {

    }

    @Override
    public Menu devolverProximoMenu() {
        return null;
    }
}
