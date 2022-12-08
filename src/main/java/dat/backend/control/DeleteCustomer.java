package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "deletecustomer", value = "/deletecustomer")
public class DeleteCustomer extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            List<User> customerList = UserFacade.getAllUsers(connectionPool);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        customerList.remove(user);
        session.setAttribute("customerList", customerList);
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
