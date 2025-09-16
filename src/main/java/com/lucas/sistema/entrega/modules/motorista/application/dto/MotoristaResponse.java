package com.lucas.sistema.entrega.modules.motorista.application.dto;

public record MotoristaResponse(long id, String nome, String cnh, String veiculo, String cidadeBase) {

    public String exibirDados(){
        return " | Nome: " + nome + "\n | CNH: " + cnh + "\n | Placa veiculo: " + veiculo + "\n | Cidade: " + cidadeBase;
    }

    @Override
    public String toString() {
        return "| ID: " + id + " | Nome: " + nome + " | CNH: " + cnh + " | Placa veiculo: " + veiculo + " | Cidade: " + cidadeBase;
    }
}
