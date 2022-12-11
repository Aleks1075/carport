package dat.backend.model.persistence;

import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class MaterialFacade {
    public static List<Material> getAllMaterials(ConnectionPool connectionPool) throws DatabaseException
    {
        return MaterialMapper.getAllMaterials(connectionPool);
    }

    public static List<Material> getAllWood(ConnectionPool connectionPool) throws DatabaseException
    {
        return MaterialMapper.getAllWood(connectionPool);
    }

    public static List<Material> getAllAccessory(ConnectionPool connectionPool) throws DatabaseException
    {
        return MaterialMapper.getAllAccessory(connectionPool);
    }

    public static void updateMaterialPrice(int material_id, double price, ConnectionPool connectionPool)
    {
        MaterialMapper.updateMaterialPrice(material_id, price, connectionPool);
    }

    public static void addMaterial(Material material, ConnectionPool connectionPool)
    {
        MaterialMapper.addMaterial(material, connectionPool);
    }

    public static void deleteMaterial(int material_id, ConnectionPool connectionPool)
    {
        MaterialMapper.deleteMaterial(material_id, connectionPool);
    }

    public static Material getMaterialById(int i, ConnectionPool connectionPool)
    {
        return MaterialMapper.getMaterialById(i, connectionPool);
    }
}
