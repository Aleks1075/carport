package dat.backend.control;

import dat.backend.model.entities.BomCart;
import dat.backend.model.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "createorder", value = "/createorder")
public class CreateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user;
        int width = 0;
        int length = 0;
        String username = null;

        if (session.getAttribute("user") != null)
        {
            user = (User) session.getAttribute("user");
            username = user.getUsername();
        }

        BomCart bomCart = (BomCart) session.getAttribute("bomCart");
        if (bomCart == null)
        {
            bomCart = new BomCart();
            session.setAttribute("bomCart", bomCart);
        }

        if (request.getParameter("width") != null && request.getParameter("length") != null)
        {
            width = Integer.parseInt(request.getParameter("width"));
            length = Integer.parseInt(request.getParameter("length"));
            session.setAttribute("width", width);
            session.setAttribute("length", length);
        }
    }
}
