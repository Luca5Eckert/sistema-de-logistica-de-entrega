package com.lucas.sistema.entrega.view.menu;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.cliente.MenuCliente;
import com.lucas.sistema.entrega.view.menu.motorista.MenuMotorista;

import static com.lucas.sistema.entrega.infraestrutura.utils.ConsoleUtil.imprimir;

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
        System.out.println(" 4- Evento de entrega");
        System.out.println(" 5- Entrega");
        System.out.println(" 6- Relatório");
        System.out.println("\n S- Sair");

        return getLeitor().nextLine();
    }
}
