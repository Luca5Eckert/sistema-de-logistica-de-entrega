package com.lucas.sistema.entrega.view.menu.pedido;

import com.lucas.sistema.entrega.infraestrutura.utils.beans.PedidoBeansUtil;
import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.MenuGeral;

public class MenuPedido extends Menu {


    public MenuPedido(Leitor leitor) {
        super(leitor);
    }

    @Override
    public void executarMenu() {
        String input = chamarMenu();

        Menu menu = switch (input.toUpperCase()){
            case "1" -> new MenuAdicionarPedido(getLeitor(), PedidoBeansUtil.toInstanceController());
            case "2" -> new MenuCancelarPedido(getLeitor(), PedidoBeansUtil.toInstanceController());
            case "3" -> new MenuPedidosPendentesPorEstado(getLeitor(), PedidoBeansUtil.toInstanceController());
            case "4" -> new MenuBuscarPedidoPorCliente(getLeitor(), PedidoBeansUtil.toInstanceController());
            case "S" -> new MenuGeral(getLeitor());
            default -> this;
        };

        setProximoMenu(menu);

    }

    private String chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                               MENU PEDIDO                                    ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" 1- Adicionar");
        System.out.println(" 2- Cancelar pedido");
        System.out.println(" 3- Pedidos pendentes por estado");
        System.out.println(" 4- Buscar pedido por CPF/CNPJ do cliente");

        System.out.println("\n S- Sair");

        return getLeitor().nextLine();
    }

}
