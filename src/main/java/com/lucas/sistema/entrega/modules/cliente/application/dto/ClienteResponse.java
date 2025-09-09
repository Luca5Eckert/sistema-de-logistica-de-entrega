package com.lucas.sistema.entrega.modules.cliente.application.dto;

public record ClienteResponse(long id, String nome, String cpfCnpj, String endereco, String cidade, String estado) {
}
