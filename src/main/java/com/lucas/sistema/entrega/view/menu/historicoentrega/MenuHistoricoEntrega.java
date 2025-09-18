package com.lucas.sistema.entrega.view.menu.historicoentrega;

import com.lucas.sistema.entrega.infraestrutura.utils.beans.HistoricoEntregaBeansUtil;
import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.menu.Menu;
import com.lucas.sistema.entrega.view.menu.MenuGeral;
import com.lucas.sistema.entrega.view.menu.entrega.MenuListarEntregas;

public class MenuHistoricoEntrega extends Menu {


    public MenuHistoricoEntrega(Leitor leitor) {
        super(leitor);
    }

    @Override
    public void executarMenu() {
        String entrada = chamarMenu();

        Menu menu = switch(entrada.toUpperCase()){
            case "1" -> new MenuRegistrarHistoricoEntrega(getLeitor(), HistoricoEntregaBeansUtil.toInstanceController());
            case "2" -> new MenuListarEventos(getLeitor(), HistoricoEntregaBeansUtil.toInstanceController());
            case "S" -> new MenuGeral(getLeitor());
            default -> this;
        };

        setProximoMenu(menu);

    }

    private String chamarMenu() {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                           HISTORICO ENTREGA                                  ");
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(" 1- Registrar Evento");
        System.out.println(" S- Sair");

        return getLeitor().nextLine();

    }
}
