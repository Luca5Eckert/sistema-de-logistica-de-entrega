package com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.dao;

import com.lucas.sistema.entrega.infraestrutura.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class HistoricoEntregaDao {

    public void adicionar(HistoricoEntrega historicoEntrega) {
        String sql = """
            INSERT INTO HistoricoEntrega (entrega_id, data_evento, descricao)
            VALUES (?, ?, ?);
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, historicoEntrega.getEntregaId());
            ps.setTimestamp(2, Timestamp.valueOf(historicoEntrega.getDataEvento()));
            ps.setString(3, historicoEntrega.getDescricao());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

}