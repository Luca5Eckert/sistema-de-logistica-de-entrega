package com.lucas.sistema.entrega.infraestrutura.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/logistica?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection toInstance() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection =  toInstance();

        if(connection != null){
            System.out.println("Conexão realizada com sucesso");
            return;
        }
        System.out.println("Erro ao conectar no banco de dados");
    }


}
