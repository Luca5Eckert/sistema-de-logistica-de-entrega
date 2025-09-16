package com.lucas.sistema.entrega.view.menu.entrega;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.MenuGeral;

public class MenuEntrega extends Menu {


    protected MenuEntrega(Leitor leitor) {
        super(leitor);
    }

    @Override
    public void executarMenu() {
        String entrada = chamarMenu();

        Menu menu = switch(entrada.toUpperCase()){
            case "S" -> new MenuGeral(getLeitor());
            default -> this;
        };

        setProximoMenu(menu);
    }

    public String chamarMenu(){

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                                 ENTREGAS                                     ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" 1- Adicionar Entrega");
        System.out.println(" 2- Atualizar Status de entrega");
        System.out.println(" 3- Excluir entrega");
        System.out.println(" 4- Entregas atrasadas por cidade");
        System.out.println("\n S- Sair ");

        return getLeitor().nextLine();
    }


}
