package dat.backend.model.persistence;

import dat.backend.model.entities.Bom;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class BomFacade {
    public static List<Bom> getBomByOrderId(int order_id, ConnectionPool connectionPool) throws DatabaseException
    {
        return BomMapper.getBomByOrderId(order_id, connectionPool);
    }
}
