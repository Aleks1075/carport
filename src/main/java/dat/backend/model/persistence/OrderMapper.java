package dat.backend.model.persistence;

import dat.backend.model.entities.Bom;
import dat.backend.model.entities.BomCart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static void createOrder(String username, int width, int length, List<Bom> bomLines, ConnectionPool connectionPool) {
        double price = 0;
        int order_id = 0;
        String status = "Afventer";

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
        String sql = "SELECT price FROM `order`";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    price += rs.getDouble("price");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public static double getPriceForLastOrder(ConnectionPool connectionPool) {
        double price = 0;
        String sql = "SELECT price FROM `order` ORDER BY order_id DESC LIMIT 1";

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

    public static int getWidthByOrderId(int order_id, ConnectionPool connectionPool) {
        int width = 0;
        String sql = "SELECT carport_width FROM `order` WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    width = rs.getInt("carport_width");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return width;
    }

    public static int getLengthByOrderId(int order_id, ConnectionPool connectionPool) {
        int length = 0;
        String sql = "SELECT carport_length FROM `order` WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    length = rs.getInt("carport_length");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return length;
    }

    public static Order getOrderById(int order_id, ConnectionPool connectionPool) {
        Order order = null;
        String sql = "SELECT * FROM `order` WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    order = new Order(
                            rs.getInt("order_id"),
                            rs.getString("username"),
                            rs.getInt("carport_length"),
                            rs.getInt("carport_width"),
                            rs.getString("order_status"),
                            rs.getDouble("price")
                    );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    public static int getOrderIdByTimestamp(ConnectionPool connectionPool) {
        int order_id = 0;
        String sql = "SELECT order_id FROM `order` ORDER BY TIMESTAMP DESC";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    order_id = rs.getInt("order_id");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order_id;
    }

    public static List<Order> getAllOrdersByUsername(String username, ConnectionPool connectionPool) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM `order` WHERE username = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    orders.add(new Order(
                            rs.getInt("order_id"),
                            rs.getString("username"),
                            rs.getTimestamp("order_date"),
                            rs.getInt("carport_length"),
                            rs.getInt("carport_width"),
                            rs.getString("order_status"),
                            rs.getDouble("price")
                    ));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    public static Order getOrder(int order_id, ConnectionPool connectionPool) {
        Order order = null;
        String sql = "SELECT * FROM `order` WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    order = new Order(
                            rs.getInt("order_id"),
                            rs.getString("username"),
                            rs.getTimestamp("order_date"),
                            rs.getInt("carport_length"),
                            rs.getInt("carport_width"),
                            rs.getString("order_status"),
                            rs.getDouble("price")
                    );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    public static List<Order> getAllOrders(ConnectionPool connectionPool) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM `order`";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    orders.add(new Order(
                            rs.getInt("order_id"),
                            rs.getString("username"),
                            rs.getTimestamp("order_date"),
                            rs.getInt("carport_length"),
                            rs.getInt("carport_width"),
                            rs.getString("order_status"),
                            rs.getDouble("price")
                    ));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    public static void deleteOrder(int order_id, ConnectionPool connectionPool) {
        String sql = "DELETE FROM `order` WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateStatusToConfirmed(int order_id, ConnectionPool connectionPool) {
        String status = "Godkendt";
        String sql = "UPDATE `order` SET order_status = ? WHERE order_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, status);
                ps.setInt(2, order_id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
