package com.lucas.sistema.entrega.view.menu.motorista;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.MenuGeral;

import static com.lucas.sistema.entrega.infraestrutura.utils.beans.MotoristaBeansUtil.toInstanceController;

public class MenuMotorista extends Menu {

    public MenuMotorista(Leitor leitor) {
        super(leitor);
    }

    @Override
    public void executarMenu() {
        String entrada = chamarMenu();

        Menu proximoMenu = switch(entrada.toUpperCase()){
            case "1" -> new MenuCadastrarMotorista(getLeitor(), toInstanceController());
            case "2" -> new MenuListarMotorista(getLeitor(), toInstanceController());
            case "S" -> new MenuGeral(getLeitor());
            default -> this;
        };

        setProximoMenu(proximoMenu);

    }

    private String chamarMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                              MENU MOTORISTA                                  ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" 1- Adicionar");
        System.out.println(" 2- Listar Motoristas");
        System.out.println(" 3- Excluir");
        System.out.println(" 4- Entregas por motorista");
        System.out.println("\n S- Sair");

        return getLeitor().nextLine();

    }

}
