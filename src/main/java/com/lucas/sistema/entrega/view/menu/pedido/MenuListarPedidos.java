package com.lucas.sistema.entrega.view.menu.pedido;

import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.modulo.pedido.application.dto.PedidoResponse;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.port.PedidoController;

import java.util.List;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimirLista;

public class MenuListarPedidos extends Menu {

    private final PedidoController pedidoController;

    public MenuListarPedidos(Leitor leitor, PedidoController pedidoController) {
        super(leitor);
        this.pedidoController = pedidoController;
    }

    @Override
    public void executarMenu() {
        var pedidos = pedidoController.pegarPedidos();

        chamarMenu(pedidos);

        setProximoMenu(new MenuPedido(getLeitor()));
    }

    private void chamarMenu(List<PedidoResponse> pedidos) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              LISTAR PEDIDOS                                  ");
        System.out.println("------------------------------------------------------------------------------");

        imprimirLista(pedidos);

        System.out.println("------------------------------------------------------------------------------");
    }
}