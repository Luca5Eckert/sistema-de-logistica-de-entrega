package com.lucas.sistema.entrega.infraestrutura.persistence.entrega.dao;

import com.lucas.sistema.entrega.infraestrutura.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modules.cliente.application.dto.ClienteEntregaResponse;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;
import com.lucas.sistema.entrega.modules.entrega.domain.Entrega;
import com.lucas.sistema.entrega.modules.entrega.domain.enumerator.EntregaStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EntregaDao {

    public void adicionar(Entrega entrega) {
        String sql = """
            INSERT INTO Entrega (pedido_id, motorista_id, data_saida, status)
            VALUES (?, ?, ?, ?);
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, entrega.getPedidoId());
            ps.setLong(2, entrega.getMotoristaId());
            ps.setTimestamp(3, Timestamp.valueOf(entrega.getDataSaida()));
            ps.setString(4, entrega.getStatus().name());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public Optional<Entrega> buscarPorId(long id) {
        String sql = """
            SELECT id, pedido_id, motorista_id, data_saida, data_entrega, status
            FROM Entrega
            WHERE id = ?;
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    long entregaId = rs.getLong("id");
                    long pedidoId = rs.getLong("pedido_id");
                    long motoristaId = rs.getLong("motorista_id");
                    LocalDateTime dataSaida = rs.getTimestamp("data_saida").toLocalDateTime();
                    LocalDateTime dataEntrega = rs.getTimestamp("data_entrega").toLocalDateTime();
                    EntregaStatus status = EntregaStatus.valueOf(rs.getString("status"));

                    Entrega entrega = new Entrega(entregaId, pedidoId, motoristaId, dataSaida, dataEntrega, status);
                    return Optional.of(entrega);
                }
            }
        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return Optional.empty();
    }

    public void save(Entrega entrega) {
        String sql = """
            UPDATE Entrega
            SET pedido_id = ?, motorista_id = ?, data_saida = ?, data_entrega = ?, status = ?
            WHERE id = ?;
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, entrega.getPedidoId());
            ps.setLong(2, entrega.getMotoristaId());
            ps.setTimestamp(3, Timestamp.valueOf(entrega.getDataSaida()));
            ps.setTimestamp(4, Timestamp.valueOf(entrega.getDataEntrega()));
            ps.setString(5, entrega.getStatus().name());
            ps.setLong(6, entrega.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public Optional<List<Entrega>> pegarTodas() {
        String sql = """
            SELECT id, pedido_id, motorista_id, data_saida, data_entrega, status
            FROM Entrega;
            """;
        List<Entrega> entregas = new ArrayList<>();
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                long pedidoId = rs.getLong("pedido_id");
                long motoristaId = rs.getLong("motorista_id");
                LocalDateTime dataSaida = rs.getTimestamp("data_saida").toLocalDateTime();
                LocalDateTime dataEntrega = rs.getTimestamp("data_entrega").toLocalDateTime();
                EntregaStatus status = EntregaStatus.valueOf(rs.getString("status"));

                Entrega entrega = new Entrega(id, pedidoId, motoristaId, dataSaida, dataEntrega, status);
                entregas.add(entrega);
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return Optional.of(entregas);
    }


    public long pegarQuantidadeEntregaPorMotorista(long idMotorista) {
        String sql = """
            SELECT COUNT(*) FROM Entrega
            WHERE motorista_id = ?;
           """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setLong(1, idMotorista);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getLong(1);
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return -1;
    }

    public List<ClienteEntregaResponse> pegarClientesComMaiorQuantidadeEntregas() {
        String sql = """
            SELECT
                c.id, c.nome, COUNT(e.id) qtd_entrega
            FROM
                Entrega e
            JOIN
                Pedido p ON e.pedido_id = p.id
            JOIN
                Cliente c ON p.cliente_id = c.id
            GROUP BY
                c.id
            ORDER BY
                COUNT(e.id) DESC
            LIMIT 5;
            """;
        List<ClienteEntregaResponse> clientes = new ArrayList<>();

        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                int qtdEntrega = rs.getInt("qtd_entrega");

                clientes.add(new ClienteEntregaResponse(id, nome, qtdEntrega));
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }

        return clientes;
    }

    public void excluirPorId(long id) {
        String sql = """
            DELETE FROM Entrega
            WHERE id = ?;
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public Map<String, Long> pegarQuantidadeEntregasPendentesPorCidade() {
        String sql = """
            SELECT
                c.cidade,
                COUNT(e.id) AS quantidade_entregas_pendentes
            FROM
                Entrega e
            JOIN
                Pedido p ON e.pedido_id = p.id
            JOIN
                Cliente c ON p.cliente_id = c.id
            WHERE
                e.status = 'EM_ROTA'
            GROUP BY
                c.cidade;
            """;
        Map<String, Long> entregasPorCidade = new HashMap<>();
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String cidade = rs.getString("cidade");
                long quantidade = rs.getLong("quantidade_entregas_pendentes");
                entregasPorCidade.put(cidade, quantidade);
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return entregasPorCidade;
    }
}