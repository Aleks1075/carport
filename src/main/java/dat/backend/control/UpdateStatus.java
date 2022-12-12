package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "updatestatus", value = "/updatestatus")
public class UpdateStatus extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int order_id = Integer.parseInt(request.getParameter("order_id"));

        OrderFacade.updateStatusToConfirmed(order_id, connectionPool);

        List<Order> orderList = null;
        orderList = OrderFacade.getAllOrders(connectionPool);
        request.setAttribute("orderlist", orderList);
        request.getRequestDispatcher("WEB-INF/adminorders.jsp").forward(request, response);
    }
}
