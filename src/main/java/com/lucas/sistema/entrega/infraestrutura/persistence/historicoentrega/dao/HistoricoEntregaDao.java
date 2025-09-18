package com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.dao;

import com.lucas.sistema.entrega.infraestrutura.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modules.historicoentrega.domain.HistoricoEntrega;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<HistoricoEntrega> pegarEventos() {
        String consulta = """
                SELECT id, entrega_id, data_evento, descricao
                FROM HistoricoEntrega
                """;
        List<HistoricoEntrega> eventos = new ArrayList<>();

        try(Connection connection = ConexaoFactory.toInstance();
            PreparedStatement statement = connection.prepareStatement(consulta)){

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                long id = rs.getLong("id");
                long entregaId = rs.getLong("entrega_id");
                LocalDateTime dataEvento = rs.getTimestamp("data_evento").toLocalDateTime();
                String descricao = rs.getString("descricao");

                HistoricoEntrega historicoEntrega = new HistoricoEntrega(id, entregaId, dataEvento, descricao);
                eventos.add(historicoEntrega);
            }

        } catch ( SQLException sqlException){
            throw new ConexaoDatabaseException("Erro ao conectar ao banco de dados");
        }

        return eventos;
    }
}