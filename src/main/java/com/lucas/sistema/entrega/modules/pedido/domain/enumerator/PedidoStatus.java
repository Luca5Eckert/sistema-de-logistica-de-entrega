package com.lucas.sistema.entrega.modules.pedido.domain.enumerator;

import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;

public enum PedidoStatus {
    PENDENTE("Pendente"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private final String escrito;

    PedidoStatus(String escrito){
        this.escrito = escrito;
    }

    public static PedidoStatus pegarValor(int entrada) {
        if(entrada < 0 || entrada >= PedidoStatus.values().length){
            throw new RuntimeException(" Opção sem correspondencia para o status pedido");
        }
        return PedidoStatus.values()[entrada];
    }

    public String getEscrito() {
        return escrito;
    }

    public static void exibirValores() {
        int contador = 0;
        for(PedidoStatus pedidoStatus : PedidoStatus.values()){
            System.out.println("| " + contador + " - " + pedidoStatus);
            contador++;
        }
    }
}
