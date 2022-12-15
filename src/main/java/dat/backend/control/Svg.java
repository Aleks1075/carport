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
import java.util.List;
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

        // Get order_id from request
        int order_id = Integer.parseInt(request.getParameter("order_id"));

        // Get order from database
        Order order = OrderFacade.getOrder(order_id, connectionPool);

        // Get width and length from order
        int width = order.getCarport_width();
        int length = order.getCarport_length();

        // Create new SVGDrawing
        SVGDrawing carport = CarportSVG.createNewSVG(0, 0, 100, 100, "0 0 855 690");

        carport.addRect(45, 45, width, length);
        // Add posts to SVGDrawing
        carport = CarportSVG.addPosts(carport, width, length);

        // Add rafters to SVGDrawing
        carport = CarportSVG.addRafters(carport, width, length);

        // Add straps to SVGDrawing
        carport = CarportSVG.addStraps(carport, width, length);

        // Add hulband to SVGDrawing
        carport = CarportSVG.addHulband(carport, width, length);

        // Add arrows to SVGDrawing
        carport = CarportSVG.addArrows(carport, width, length);

        //Create new SVGDrawing from side view
        SVGDrawing carportSide = CarportSVG.createNewSVG(0, 0, 100, 100, "0 0 855 690");

        carportSide.addRect(45, 45, width, length);
        // Add posts to SVGDrawing
        carportSide = CarportSVG.addPosts(carportSide, width, length);

        // Add rafters to SVGDrawing

        // Add straps to SVGDrawing

        // Add hulband to SVGDrawing

        // Add arrows to SVGDrawing

        // Send SVGDrawing to client
        request.setAttribute("svgside", carportSide.toString());
        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("WEB-INF/svg.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
