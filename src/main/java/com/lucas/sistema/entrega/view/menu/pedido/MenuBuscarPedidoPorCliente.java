package com.lucas.sistema.entrega.view.menu.pedido;

import com.lucas.sistema.entrega.modules.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.port.PedidoController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;
import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuBuscarPedidoPorCliente extends Menu {

    private final PedidoController pedidoController;

    protected MenuBuscarPedidoPorCliente(Leitor leitor, PedidoController pedidoController) {
        super(leitor);
        this.pedidoController = pedidoController;
    }

    @Override
    public void executarMenu() {
        String cpfCnpj = chamarMenu();

        if(cpfCnpj.equalsIgnoreCase("S")){
            setProximoMenu(new MenuPedido(getLeitor()));
            return;
        }

        var pedidos = pedidoController.buscarPedidosPorCliente(cpfCnpj);

        if (pedidos.isEmpty()) {
            imprimir("| Não foram encontrados pedidos para este cliente.");
        } else {
            imprimirLista(pedidos);
        }

        setProximoMenu(new MenuPedido(getLeitor()));
    }

    private String chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                      BUSCAR PEDIDO POR CLIENTE                               ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" S- Sair");

        imprimir("| Digite o CPF/CNPJ do cliente: ");
        return  getLeitor().nextLine();

    }

}