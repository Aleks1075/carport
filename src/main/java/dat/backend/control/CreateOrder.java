package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bom;
import dat.backend.model.entities.BomCart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.services.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet(name = "createorder", value = "/createorder")
public class CreateOrder extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calculator calculator = new Calculator();
        OrderFacade orderFacade = new OrderFacade();

        HttpSession session = request.getSession();
        User user;
        int width = 0;
        int length = 0;
        String username = "";

        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            username = user.getUsername();
        }

        BomCart bomCart = (BomCart) session.getAttribute("bomCart");
        if (bomCart == null) {
            bomCart = new BomCart();
            session.setAttribute("bomCart", bomCart);
        }

        if (request.getParameter("width") != null && request.getParameter("length") != null) {
            width = Integer.parseInt(request.getParameter("width"));
            length = Integer.parseInt(request.getParameter("length"));
            session.setAttribute("width", width);
            session.setAttribute("length", length);
        }

            //Add bill of materials
            try {
                for (Bom bom : calculator.calculateCarport(width, length)) {
                    bomCart.getBomLines().add(bom);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            orderFacade.createOrder(username, width, length, bomCart.getBomLines(), connectionPool);


            //Clear bill of materials
            try {
                calculator.calculateCarport(width, length).clear();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
            bomCart.getBomLines().clear();

            //Get price from the latest order
            DecimalFormat df = new DecimalFormat("#.##");
            double price = orderFacade.getPrice(connectionPool);
            String formattedPrice = df.format(price);
            session.setAttribute("price", formattedPrice);


            request.getRequestDispatcher("WEB-INF/overview.jsp").forward(request, response);
    }
}
