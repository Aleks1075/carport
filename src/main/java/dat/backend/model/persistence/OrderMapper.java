package dat.backend.model.persistence;

import dat.backend.model.entities.Bom;
import dat.backend.model.entities.BomCart;
import dat.backend.model.entities.User;

import java.sql.*;
import java.util.List;

public class OrderMapper {
    public static void createOrder(String username, int width, int length, List<Bom> bomLines, ConnectionPool connectionPool) {
        double price = 0;
        int order_id = 0;
        String status = "pending";

        for (Bom bom : bomLines) {
            price += bom.getPrice();
        }

        String sql = "INSERT INTO `order` (username, carport_length, carport_width, order_status, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, username);
                ps.setInt(2, length);
                ps.setInt(3, width);
                ps.setString(4, status);
                ps.setDouble(5, price);

                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                order_id = ids.getInt(1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            for (Bom bom : bomLines) {
                createBom(order_id, bom, connectionPool);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public static void createBom(int order_id, Bom bom, ConnectionPool connectionPool) {
        String sql = "INSERT INTO bom (order_id, material_id, definition, description, unit, length, price, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order_id);
                ps.setInt(2, bom.getMaterialId());
                ps.setString(3, bom.getDefinition());
                ps.setString(4, bom.getDescription());
                ps.setString(5, bom.getUnit());
                ps.setInt(6, bom.getLength());
                ps.setDouble(7, bom.getPrice());
                ps.setInt(8, bom.getQuantity());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static double getOrderPriceByTimestamp(ConnectionPool connectionPool) {
        double price = 0;
        String sql = "SELECT price FROM `order` ORDER BY TIMESTAMP DESC";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    price = rs.getDouble("price");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public static double getTotalPrice(ConnectionPool connectionPool) {
        double price = 0;
        String sql = "SELECT SUM(price) AS total_price FROM `order`";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    price = rs.getDouble("price");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public static double getPrice(ConnectionPool connectionPool) {
        double price = 0;
        String sql = "SELECT price FROM `order` ORDER BY TIMESTAMP DESC";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    price = rs.getDouble("price");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }
}
