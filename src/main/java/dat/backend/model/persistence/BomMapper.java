package dat.backend.model.persistence;

import dat.backend.model.entities.Bom;
import dat.backend.model.entities.BomCart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class BomMapper {
    public List<Bom> getBomByOrderId(int orderId, ConnectionPool connectionPool) throws DatabaseException {
        List<Bom> bomList = new ArrayList<>();
        String sql = "select * from bom where order_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    String definition = rs.getString("definition");
                    String description = rs.getString("description");
                    String unit = rs.getString("unit");
                    int length = rs.getInt("length");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");

                    Bom tmpBomList = new Bom(materialId, definition, description, unit, length, price, quantity);
                    bomList.add(tmpBomList);
                }
                return bomList;
            } catch (SQLException ex) {
                throw new DatabaseException(ex.getMessage());
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException("Connection to database could not be established");
        }
    }

    public Bom getBomFromOrderByMaterialId(int orderId, int materialId, ConnectionPool connectionPool) throws DatabaseException {
        Bom bom = null;
        String sql = "select * from bom where material_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, materialId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String definition = rs.getString("definition");
                    String description = rs.getString("description");
                    String unit = rs.getString("unit");
                    int length = rs.getInt("length");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");

                    bom = new Bom(materialId, definition, description, unit, length, price, quantity);

                }
                return bom;
            } catch (SQLException ex) {
                throw new DatabaseException(ex.getMessage());
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException("Connection to database could not be established");
        }
    }
}