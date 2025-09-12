package com.lucas.sistema.entrega.infraestrutura.persistence.conexao.exception;

public class ConexaoDatabaseException extends RuntimeException {
    public ConexaoDatabaseException(String message) {
        super(message);
    }
}
