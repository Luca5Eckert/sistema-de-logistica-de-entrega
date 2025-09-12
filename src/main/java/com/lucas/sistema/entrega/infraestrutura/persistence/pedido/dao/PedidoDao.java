package com.lucas.sistema.entrega.infraestrutura.persistence.pedido.dao;

import com.lucas.sistema.entrega.infraestrutura.conexao.ConexaoFactory;
import com.lucas.sistema.entrega.infraestrutura.conexao.exception.ConexaoDatabaseException;
import com.lucas.sistema.entrega.modules.pedido.domain.Pedido;
import com.lucas.sistema.entrega.modules.pedido.domain.enumerator.PedidoStatus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PedidoDao {

    public void adicionar(Pedido pedido) {
        String sql = """
            INSERT INTO Pedido (cliente_id, data_pedido, volume_m3, peso_kg, status)
            VALUES (?, ?, ?, ?, ?);
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, pedido.getClienteId());
            ps.setDate(2, Date.valueOf(pedido.getDataPedido().format(DateTimeFormatter.ISO_LOCAL_TIME)));
            ps.setDouble(3, pedido.getVolumeM3());
            ps.setDouble(4, pedido.getPesoKg());
            ps.setString(5, pedido.getStatus().name());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public Optional<Pedido> buscar(long pedidoId) {
        String sql = """
            SELECT id, cliente_id, data_pedido, volume_m3, peso_kg, status
            FROM Pedido
            WHERE id = ?;
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, pedidoId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    long id = rs.getLong("id");
                    long clienteId = rs.getLong("cliente_id");
                    LocalDateTime dataPedido = rs.getDate("data_pedido").toLocalDate().atStartOfDay();
                    double volumeM3 = rs.getDouble("volume_m3");
                    double pesoKg = rs.getDouble("peso_kg");
                    PedidoStatus status = PedidoStatus.valueOf(rs.getString("status"));

                    Pedido pedido = new Pedido(id, clienteId, dataPedido, volumeM3, pesoKg, status);
                    return Optional.of(pedido);
                }
            }
        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return Optional.empty();
    }

    public void salvar(Pedido pedido) {
        String sql = """
            UPDATE Pedido
            SET cliente_id = ?, data_pedido = ?, volume_m3 = ?, peso_kg = ?, status = ?
            WHERE id = ?;
            """;
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, pedido.getClienteId());
            ps.setDate(2, Date.valueOf(pedido.getDataPedido().format(DateTimeFormatter.ISO_LOCAL_TIME)));
            ps.setDouble(3, pedido.getVolumeM3());
            ps.setDouble(4, pedido.getPesoKg());
            ps.setString(5, pedido.getStatus().name());
            ps.setLong(6, pedido.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
    }

    public Map<String, Long> pegarQuantidadePedidosPendentesPorEstado() {
        String sql = """
            SELECT
                c.estado,
                COUNT(p.id) AS quantidade_pedidos_pendentes
            FROM
                Pedido p
            JOIN
                Cliente c ON p.cliente_id = c.id
            WHERE
                p.status = 'PENDENTE'
            GROUP BY
                c.estado;
            """;
        Map<String, Long> pedidosPendentesPorEstado = new HashMap<>();
        try (Connection conn = ConexaoFactory.toInstance();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String estado = rs.getString("estado");
                long quantidade = rs.getLong("quantidade_pedidos_pendentes");
                pedidosPendentesPorEstado.put(estado, quantidade);
            }

        } catch (SQLException e) {
            throw new ConexaoDatabaseException("Erro ao conectar ao banco dados");
        }
        return pedidosPendentesPorEstado;
    }
}