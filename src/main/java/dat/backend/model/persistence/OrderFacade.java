package dat.backend.model.persistence;

import dat.backend.model.entities.Bom;
import dat.backend.model.entities.Order;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

public class OrderFacade
{
    public static int getWidthByOrderId(int order_id, ConnectionPool connectionPool)
    {
        return OrderMapper.getWidthByOrderId(order_id, connectionPool);
    }

    public static int getLengthByOrderId(int order_id, ConnectionPool connectionPool)
    {
        return OrderMapper.getLengthByOrderId(order_id, connectionPool);
    }

    public static Order getOrderById(int order_id, ConnectionPool connectionPool)
    {
        return OrderMapper.getOrderById(order_id, connectionPool);
    }

    public static int getOrderIdByTimestamp(ConnectionPool connectionPool)
    {
        return OrderMapper.getOrderIdByTimestamp(connectionPool);
    }

    public static List<Order> getAllOrdersByUsername(String username, ConnectionPool connectionPool)
    {
        return OrderMapper.getAllOrdersByUsername(username, connectionPool);
    }

    public static Order getOrder(int order_id, ConnectionPool connectionPool)
    {
        return OrderMapper.getOrder(order_id, connectionPool);
    }

    public static List<Order> getAllOrders(ConnectionPool connectionPool)
    {
        return OrderMapper.getAllOrders(connectionPool);
    }

    public static void deleteOrder(int order_id, ConnectionPool connectionPool)
    {
        OrderMapper.deleteOrder(order_id, connectionPool);
    }

    public static void deleteBom(int order_id, ConnectionPool connectionPool)
    {
        BomMapper.deleteBom(order_id, connectionPool);
    }

    public static void updateStatusToConfirmed(int order_id, ConnectionPool connectionPool)
    {
        OrderMapper.updateStatusToConfirmed(order_id, connectionPool);
    }

    public static int getOrderId(Order order, ConnectionPool connectionPool)
    {
        return OrderMapper.getOrderId(order, connectionPool);
    }

    public static Order getOrderTest(int order_id, ConnectionPool connectionPool)
    {
        return OrderMapper.getOrderTest(order_id, connectionPool);
    }

    public static void deleteFromOrderAndBom(int order_id, ConnectionPool connectionPool)
    {
        OrderMapper.deleteFromOrderAndBom(order_id, connectionPool);
    }

    public static Order getOrderByOrderId(String username, ConnectionPool connectionPool)
    {
        return OrderMapper.getOrderByOrderId(username, connectionPool);
    }

    public void createOrder(String username, int width, int length, List<Bom> bomLines, ConnectionPool connectionPool)
    {
        OrderMapper.createOrder(username, width, length, bomLines, connectionPool);
    }

    public double getPriceForLastOrder(ConnectionPool connectionPool)
    {
        return OrderMapper.getPriceForLastOrder(connectionPool);
    }
}
