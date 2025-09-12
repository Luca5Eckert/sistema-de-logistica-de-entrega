package com.lucas.sistema.entrega.infraestrutura.persistence.cliente.dao;

import com.lucas.sistema.entrega.infraestrutura.persistence.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.persistence.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modules.cliente.domain.Cliente;

import java.util.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, cpf_cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpfCnpj());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getEstado());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    // Busca um cliente por ID, retornando um Optional para lidar com a ausência do cliente.
    public Optional<Cliente> buscarPorId(long id) {
        String sql = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado FROM Cliente WHERE id = ?";
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente(rs.getLong("id"));

                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpfCnpj(rs.getString("cpf_cnpj"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setCidade(rs.getString("cidade"));
                    cliente.setEstado(rs.getString("estado"));
                    return Optional.of(cliente);
                }
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return Optional.empty();
    }

    // Verifica se há alguma entrega dependente de um pedido do cliente.
    public boolean buscarEntregaDependente(long id) {
        String sql = "SELECT EXISTS (SELECT 1 FROM Entrega e JOIN Pedido p ON e.pedido_id = p.id WHERE p.cliente_id = ?)";
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

    // Verifica se há algum pedido dependente do cliente.
    public boolean buscarPedidoDependente(long id) {
        String sql = "SELECT EXISTS (SELECT 1 FROM Pedido WHERE cliente_id = ?)";
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

    // Exclui um cliente por ID.
    public void excluirPorId(long id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }
}