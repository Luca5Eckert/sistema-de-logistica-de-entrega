package com.lucas.sistema.entrega.modules.cliente.application.dto;

public record ClienteEntregaResponse(long idCliente, String nome, int quantidadeEntrega) {

    @Override
    public String toString() {
        return "| Id: " + idCliente + " | Nome: " + nome + " | Quantidade entrega: " + quantidadeEntrega;
    }
}
