package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bom;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BomFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "customerorderscontent", value = "/customerorderscontent")
public class CustomerOrdersContent extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Get order id
        int order_id = Integer.parseInt(request.getParameter("order_id"));

        //Get specific order
        Order order = OrderFacade.getOrder(order_id, connectionPool);
        request.setAttribute("order1", order);

        //Get Bill of Materials from specific order.
        List<Bom> bom = null;
        try {
            bom = BomFacade.getBomByOrderId(order_id, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("bom", bom);

        //Get Order Status from specific order
        String status = order.getOrder_status();
        request.setAttribute("status", status);

        //Get Order Price from specific order
        DecimalFormat df = new DecimalFormat("#.00");
        Double price = order.getPrice();
        request.setAttribute("price", df.format(price));

        double length = order.getCarport_length();
        double width = order.getCarport_width();
        request.setAttribute("length", length);
        request.setAttribute("width", width);

        request.getRequestDispatcher("WEB-INF/customerorderscontent.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
}
