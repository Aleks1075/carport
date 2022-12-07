package dat.backend.model.persistence;

import dat.backend.model.entities.Material;

import java.util.List;

public class MaterialFacade {
    public static List<Material> getAllMaterials(ConnectionPool connectionPool)
    {
        return MaterialMapper.getAllMaterials(connectionPool);
    }
}
