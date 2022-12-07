package dat.backend.model.persistence;

import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper
{
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
                    Material tmpMaterial = new Material (materialId, description, type, unit, unit_price);
                    materialList.add(tmpMaterial);
                }
                return materialList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException("Could not get all materials");
        }
    }
}
