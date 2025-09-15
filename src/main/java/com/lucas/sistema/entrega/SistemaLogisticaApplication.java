package com.lucas.sistema.entrega;

import com.lucas.sistema.entrega.view.Leitor;
import com.lucas.sistema.entrega.view.MenuManager;
import com.lucas.sistema.entrega.view.MenuProvider;
import com.lucas.sistema.entrega.view.menu.MenuGeral;

public class SistemaLogisticaApplication {

    public static void main(String[] args) {

        MenuManager menuManager = new MenuManager(new MenuProvider(new MenuGeral(new Leitor())));

        menuManager.iniciarFluxo();
    }

}
