package com.lucas.sistema.entrega.infraestrutura.conexao.exception;

public class ConexaoApiException extends RuntimeException {
    public ConexaoApiException(String message) {
        super(message);
    }
}
