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
    public static List<Bom> getBomByOrderId(int order_id, ConnectionPool connectionPool) throws DatabaseException {
        List<Bom> bomList = new ArrayList<>();
        String sql = "select * from bom where order_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
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

    public static void deleteBom(int order_id, ConnectionPool connectionPool)
    {
        String sql = "delete from bom where order_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(BomMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BomMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}