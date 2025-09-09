package com.lucas.sistema.entrega.view;

public abstract class Menu<RESPOSTA> {
    private RESPOSTA resposta;

    abstract void chamarMenu();

    abstract void executarMenu();

    abstract Menu devolverProximoMenu();

    public RESPOSTA getResposta() {
        return resposta;
    }

    public void setResposta(RESPOSTA resposta) {
        this.resposta = resposta;
    }
}
