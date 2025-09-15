package com.lucas.sistema.entrega.view.menu;

import com.lucas.sistema.entrega.view.Leitor;

public abstract class Menu{
    private Menu proximoMenu;
    private final Leitor leitor;

    protected Menu(Leitor leitor) {
        this.leitor = leitor;
    }

    public abstract void executarMenu();

    public Menu devolverProximoMenu(){
        return proximoMenu;
    }

    public Menu getProximoMenu() {
        return proximoMenu;
    }

    public void setProximoMenu(Menu proximoMenu) {
        this.proximoMenu = proximoMenu;
    }

    public Leitor getLeitor() {
        return leitor;
    }

}
