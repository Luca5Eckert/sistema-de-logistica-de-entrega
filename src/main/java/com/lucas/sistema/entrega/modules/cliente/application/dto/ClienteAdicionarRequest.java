package com.lucas.sistema.entrega.modules.cliente.application.dto;

public record ClienteAdicionarRequest(String nome, String cpfCnpj, String endereco, String cidade, String estado) {

    @Override
    public String toString() {
        return "Nome: " + nome + " | CPF/CNPJ: " + cpfCnpj + " | Endereço: " + endereco + " | Cidade: " + cidade + " | Estado: "  + estado;
    }
}
