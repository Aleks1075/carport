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
        //Delete customer
        String username = request.getParameter("username");
        UserFacade.deleteUser(username, connectionPool);

        //Get all customers
        List<User> customerList = null;
        try {
            customerList = UserFacade.getAllUsers(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("customerList", customerList);

        request.getRequestDispatcher("WEB-INF/customerisdeleted.jsp").forward(request, response);
    }
}
