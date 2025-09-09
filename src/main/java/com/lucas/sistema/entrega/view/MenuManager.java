package com.lucas.sistema.entrega.view;

public class MenuManager {

    private final MenuProvider menuProvider;

    public MenuManager(MenuProvider menuProvider) {
        this.menuProvider = menuProvider;
    }

    public void iniciarFluxo(){
        while(menuProvider.verificarContinuidade()){
            menuProvider.executarMenu();
        }
    }
}
