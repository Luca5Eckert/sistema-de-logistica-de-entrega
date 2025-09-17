package com.lucas.sistema.entrega.view.menu;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.cliente.MenuCliente;
import com.lucas.sistema.entrega.view.menu.entrega.MenuEntrega;
import com.lucas.sistema.entrega.view.menu.historicoentrega.MenuHistoricoEntrega;
import com.lucas.sistema.entrega.view.menu.motorista.MenuMotorista;
import com.lucas.sistema.entrega.view.menu.pedido.MenuPedido;

public class MenuGeral extends Menu {

    public MenuGeral(Leitor leitor) {
        super(leitor);
    }

    @Override
    public void executarMenu() {

        var escolha = chamarMenu();

        Menu proximoMenu = switch(escolha.toUpperCase()){
            case "1" -> new MenuCliente(getLeitor());
            case "2" -> new MenuMotorista(getLeitor());
            case "3" -> new MenuPedido(getLeitor());
            case "4" -> new MenuEntrega(getLeitor());
            case "5" -> new MenuHistoricoEntrega(getLeitor());
            case "S" -> null;
            default -> this;
        };

        setProximoMenu(proximoMenu);

    }

    private String chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                                  MENU GERAL                                  ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" 1- Cliente");
        System.out.println(" 2- Motorista");
        System.out.println(" 3- Pedido");
        System.out.println(" 4- Entrega");
        System.out.println(" 5- Evento de entrega");
        System.out.println("\n S- Sair");

        return getLeitor().nextLine();
    }
}
