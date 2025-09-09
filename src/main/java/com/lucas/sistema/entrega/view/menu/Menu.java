package com.lucas.sistema.entrega.view.menu;

import com.lucas.sistema.entrega.view.Leitor;

public abstract class Menu<RESPOSTA> {
    private RESPOSTA resposta;
    private final Leitor leitor;

    protected Menu(Leitor leitor) {
        this.leitor = leitor;
    }

    public abstract void chamarMenu();

    public abstract void executarMenu();

    public abstract Menu devolverProximoMenu();

    public RESPOSTA getResposta() {
        return resposta;
    }

    public void setResposta(RESPOSTA resposta) {
        this.resposta = resposta;
    }

    public Leitor getLeitor() {
        return leitor;
    }

}
