package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerorders", value = "/customerorders")
public class CustomerOrders extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        //Get user ID
        User user;
        String username = "";
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            username = user.getUsername();
        }
        //Get all orders
        List<Order> order = OrderFacade.getAllOrdersByUsername(username, connectionPool);

        request.setAttribute("order", order);

        request.getRequestDispatcher("WEB-INF/customerorders.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
