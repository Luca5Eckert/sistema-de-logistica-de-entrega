package com.lucas.sistema.entrega.view;

import com.lucas.sistema.entrega.view.menu.Menu;

public class MenuProvider {

    private Menu<?> menu;

    public MenuProvider(Menu<?> menu) {
        this.menu = menu;
    }

    public boolean verificarContinuidade() {
        return menu != null;
    }

    public void executarMenu() {
        try{

            menu.chamarMenu();
            menu.executarMenu();
            menu = menu.devolverProximoMenu();

        }catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        }

    }
}
