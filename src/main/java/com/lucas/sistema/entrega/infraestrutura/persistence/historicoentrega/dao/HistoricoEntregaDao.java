package com.lucas.sistema.entrega.infraestrutura.persistence.historicoentrega.dao;

import com.lucas.sistema.entrega.infraestrutura.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modulo.historicoentrega.domain.HistoricoEntrega;

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
                FROM HistoricoEntrega;
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

    public List<HistoricoEntrega> pegarHistoricoDeEntrega(long idEntrega) {
        String consulta = """
                SELECT he.id, he.data_evento, he.descricao
                FROM HistoricoEntrega he
                JOIN Entrega e ON e.id = he.entrega_id 
                WHERE he.entrega_id = ?
                ORDER BY he.data_evento DESC;
                """;
        List<HistoricoEntrega> eventos = new ArrayList<>();

        try(Connection connection = ConexaoFactory.toInstance();
            PreparedStatement statement = connection.prepareStatement(consulta)){

            statement.setLong(1, idEntrega);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                long id = resultSet.getLong("id");
                LocalDateTime dataEvento = resultSet.getTimestamp("data_evento").toLocalDateTime();
                String descricao = resultSet.getString("descricao");

                HistoricoEntrega evento = new HistoricoEntrega(id, idEntrega, dataEvento, descricao);
                eventos.add(evento);
            }

        } catch ( SQLException sqlException){
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }

        return eventos;

    }
}