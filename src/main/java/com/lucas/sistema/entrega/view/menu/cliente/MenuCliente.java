package com.lucas.sistema.entrega.view.menu.cliente;

import com.lucas.sistema.entrega.infraestrutura.utils.ClienteBeansUtil;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.MenuGeral;

public class MenuCliente extends Menu {

    public MenuCliente(Leitor leitor) {
        super(leitor);
    }

    @Override
    public void executarMenu() {
        String entrada = chamarMenu();

        Menu proximoMenu = switch(entrada.toUpperCase()){
            case "1" -> new MenuAdicionarCliente(getLeitor(), ClienteBeansUtil.toInstanceController());
            case "S" -> new MenuGeral(getLeitor());
            default -> this;
        };

        setProximoMenu(proximoMenu);

    }

    private String chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                                MENU CLIENTE                                  ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" 1- Adicionar");
        System.out.println(" 2- Excluir");
        System.out.println(" 3- Clientes com maior volume entregue");
        System.out.println("\n S- Sair");
        return getLeitor().nextLine();
    }

}
