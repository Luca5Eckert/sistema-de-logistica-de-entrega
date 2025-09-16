package com.lucas.sistema.entrega.modules.cliente.application.dto;

public record ClienteResponse(long id, String nome, String cpfCnpj, String endereco, String cidade, String estado) {

    @Override
    public String toString() {
        return "| Id: " + id + " | Nome: " + nome + " | CPF/CNPJ: " + cpfCnpj + " | Endereço: " + endereco + " | Cidade: " + cidade + " | Estado: "  + estado;
    }

    public String exibirDados(){
        return " | Nome: " + nome + "\n | CPF/CNPJ: " + cpfCnpj + "\n | Endereço: " + endereco + "\n | Cidade: " + cidade + "\n | Estado: "  + estado;
    }

}
