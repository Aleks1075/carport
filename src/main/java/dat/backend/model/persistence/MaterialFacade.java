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
}
