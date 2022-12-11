package dat.backend.model.persistence;

import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {
    public static List<Material> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException {
        List<Material> materialList = new ArrayList<>();
        String sql = "select * from material";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String unit = rs.getString("unit");
                    double unit_price = rs.getDouble("unit_price");
                    Material tmpMaterial = new Material(materialId, description, type, unit, unit_price);
                    materialList.add(tmpMaterial);
                }
                return materialList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException("Could not get all materials");
        }
    }

    public static List<Material> getAllWood(ConnectionPool connectionPool) throws DatabaseException {
        List<Material> materialList = new ArrayList<>();
        String sql = "select * from material where type = 'træ & tagplader'";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String unit = rs.getString("unit");
                    double unit_price = rs.getDouble("unit_price");
                    Material tmpMaterial = new Material(materialId, description, type, unit, unit_price);
                    materialList.add(tmpMaterial);
                }
                return materialList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException("Could not get all wood");
        }
    }

    public static List<Material> getAllAccessory(ConnectionPool connectionPool) throws DatabaseException {
        List<Material> materialList = new ArrayList<>();
        String sql = "select * from material where type = 'beslag & skruer'";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String unit = rs.getString("unit");
                    double unit_price = rs.getDouble("unit_price");
                    Material tmpMaterial = new Material(materialId, description, type, unit, unit_price);
                    materialList.add(tmpMaterial);
                }
                return materialList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException("Could not get all accessories");
        }
    }

    public static void updateMaterialPrice(int material_id, double price, ConnectionPool connectionPool) {
        String sql = "update material set unit_price = ? where material_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, price);
                ps.setInt(2, material_id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addMaterial(Material material, ConnectionPool connectionPool) {
        String sql = "insert into material (description, type, unit, unit_price) values (?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, material.getDescription());
                ps.setString(2, material.getType());
                ps.setString(3, material.getUnit());
                ps.setDouble(4, material.getUnit_price());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMaterial(int material_id, ConnectionPool connectionPool) {
        String sql = "delete from material where material_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, material_id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Material getMaterialById(int i, ConnectionPool connectionPool) {
        Material material = null;
        String sql = "select * from material where material_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, i);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    String description = rs.getString("description");
                    String type = rs.getString("type");
                    String unit = rs.getString("unit");
                    double unit_price = rs.getDouble("unit_price");
                    material = new Material(materialId, description, type, unit, unit_price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return material;
        }
}
