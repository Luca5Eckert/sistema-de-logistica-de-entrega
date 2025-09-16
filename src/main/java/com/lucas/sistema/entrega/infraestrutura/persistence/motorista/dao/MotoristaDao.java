package com.lucas.sistema.entrega.infraestrutura.persistence.motorista.dao;

import com.lucas.sistema.entrega.infraestrutura.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modules.motorista.domain.Motorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDao {

    public void cadastrar(Motorista motorista) {
        String sql = """
            INSERT INTO Motorista (nome, cnh, veiculo, cidade_base)
            VALUES (?, ?, ?, ?);
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, motorista.getNome());
            ps.setString(2, motorista.getCnh());
            ps.setString(3, motorista.getVeiculo());
            ps.setString(4, motorista.getCidadeBase());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public boolean excluirPorId(long id) {
        String sql = """
            DELETE FROM Motorista
            WHERE id = ?;
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public boolean buscarEntregaDependente(long id) {
        String sql = """
            SELECT EXISTS (SELECT 1 FROM Entrega WHERE motorista_id = ?);
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return false;
    }

    public boolean buscarPedidoDependente(long id) {
        String sql = """
            SELECT EXISTS (
                SELECT 1
                FROM Entrega e
                JOIN Pedido p ON e.pedido_id = p.id
                WHERE e.motorista_id = ?
            );
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return false;
    }

    public boolean existePorId(long motoristaId) {
        String sql = "SELECT COUNT(1) FROM Motorista WHERE id = ?;";
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, motoristaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco de dados ao verificar a existência do motorista.");
        }
        return false;
    }

    public List<Motorista> pegarMotoristas() {
        String sql = "SELECT id, nome, cnh, veiculo, cidade_base FROM Motorista;";
        List<Motorista> motoristas = new ArrayList<>();
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String cnh = rs.getString("cnh");
                String veiculo = rs.getString("veiculo");
                String cidadeBase = rs.getString("cidade_base");

                Motorista motorista = new Motorista(id, nome, cnh, veiculo, cidadeBase);
                motoristas.add(motorista);
            }
            return motoristas;
        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco de dados ao listar motoristas.");
        }
    }

    public Motorista buscarPeloId(long id) {
        String sql = "SELECT id, nome, cnh, veiculo, cidade_base FROM Motorista WHERE id = ?;";
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Motorista(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getString("cnh"),
                            rs.getString("veiculo"),
                            rs.getString("cidade_base")
                    );
                }
            }
        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao buscar motorista pelo ID.");
        }
        return null;
    }

}