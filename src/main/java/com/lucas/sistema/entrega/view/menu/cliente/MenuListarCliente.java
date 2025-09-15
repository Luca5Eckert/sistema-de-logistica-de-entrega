package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.ClienteController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuListarCliente extends Menu {

    private final ClienteController clienteController;

    protected MenuListarCliente(Leitor leitor, ClienteController clienteController) {
        super(leitor);
        this.clienteController = clienteController;
    }


    @Override
    public void executarMenu() {
        var clientes = clienteController.listar();

        chamarMenu(clientes);

        setProximoMenu(new MenuCliente(getLeitor()));
    }

    private void chamarMenu(List<ClienteResponse> clientes) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              LISTAR CLIENTES                                 ");
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(clientes);

        System.out.println("------------------------------------------------------------------------------");


    }


}
