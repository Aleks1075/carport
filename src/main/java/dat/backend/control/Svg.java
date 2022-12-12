package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVGDrawing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "svg", value = "/svg")
public class Svg extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        //Get order by id
        int order_id = Integer.parseInt(request.getParameter("order_id"));
//        Order order = OrderFacade.getOrderIdByTimestamp(order_id, connectionPool);

        //Get width and length
        int width = OrderFacade.getWidthByOrderId(order_id, connectionPool);
        int length = OrderFacade.getLengthByOrderId(order_id, connectionPool);

        SVGDrawing carport = CarportSVG.createNewSVG(0, 0, 100, 60, "0 0 855 690");
        carport = CarportSVG.addPosts(carport, width, length);
        carport = CarportSVG.addStraps(carport, width, length);
        carport = CarportSVG.addRafters(carport, width, length);
        carport = CarportSVG.addHulband(carport, width, length);
        carport = CarportSVG.addArrows(carport, width, length);

        request.setAttribute("svg", carport);
        request.getRequestDispatcher("WEB-INF/svg.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
