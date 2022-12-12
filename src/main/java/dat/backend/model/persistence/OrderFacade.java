package dat.backend.model.persistence;

import dat.backend.model.entities.Bom;

import java.util.List;

public class OrderFacade
{
    public void createOrder(String username, int width, int length, List<Bom> bomLines, ConnectionPool connectionPool)
    {
        OrderMapper.createOrder(username, width, length, bomLines, connectionPool);
    }

    public double getPrice(ConnectionPool connectionPool)
    {
        return OrderMapper.getPrice(connectionPool);
    }
}
