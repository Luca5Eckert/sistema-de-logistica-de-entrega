package com.lucas.sistema.entrega.modules.cliente.application.dto;

public record ClienteAdicionarRequest(String nome, String cpfCnpj, String cidade, String estado) {
}
