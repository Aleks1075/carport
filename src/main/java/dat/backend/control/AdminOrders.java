package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bom;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminorders", value = "/adminorders")
public class AdminOrders extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Get all orders
        List<Order> orderList = OrderFacade.getAllOrders(connectionPool);

        //Show order content from specific orders
        if (request.getParameter("content") != null) {
            int order_id = Integer.parseInt(request.getParameter("content"));
            request.setAttribute("order_id", order_id);
            List<Bom> bom = null;
            try {
                bom = BomFacade.getBomByOrderId(order_id, connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
            request.setAttribute("bom", bom);
            request.getRequestDispatcher("WEB-INF/customerorderscontent.jsp").forward(request, response);
        }

        //Update Order Status
//        if (request.getParameter("update") != null) {
//            int order_id = Integer.parseInt(request.getParameter("update"));
//            request.setAttribute("order_id", order_id);
//            OrderFacade.updateStatusToConfirmed(order_id, connectionPool);
//            orderList = OrderFacade.getAllOrders(connectionPool);
//        }
        //Delete order
        if (request.getParameter("delete") != null) {
            int order_id = Integer.parseInt(request.getParameter("delete"));
            request.setAttribute("order_id", order_id);
            OrderFacade.deleteOrder(order_id, connectionPool);
            OrderFacade.deleteBom(order_id, connectionPool);
            orderList = OrderFacade.getAllOrders(connectionPool);
        }
        request.setAttribute("orderlist", orderList);

        request.getRequestDispatcher("WEB-INF/adminorders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
