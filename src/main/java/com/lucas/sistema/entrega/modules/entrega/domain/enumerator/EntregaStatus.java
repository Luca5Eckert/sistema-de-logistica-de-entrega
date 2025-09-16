package com.lucas.sistema.entrega.modules.entrega.domain.enumerator;

public enum EntregaStatus {
    EM_ROTA("Em rota"),
    ENTREGUE("Entregue"),
    ATRASADA("Atrasada");

    private final String escrito;

    EntregaStatus(String escrito){
        this.escrito = escrito;
    }

    public static EntregaStatus pegarValor(int entrada) {
        if(entrada < 0 || entrada >= EntregaStatus.values().length){
            throw new RuntimeException(" Opção sem correspondencia para o status entrega");
        }
        return EntregaStatus.values()[entrada];
    }

    public String getEscrito() {
        return escrito;
    }

    public static void exibirValores() {
        int contador = 0;
        for(EntregaStatus entregaStatus : EntregaStatus.values()){
            System.out.println("| " + contador + " - " + entregaStatus);
            contador++;
        }
    }
}
