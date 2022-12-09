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
import java.util.List;

@WebServlet(name = "updateprofile", value = "/updateprofile")
public class UpdateProfile extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Update user info
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));

        User user = (User) request.getSession().getAttribute("user");
        user.setUsername(username);
        user.setEmail(email);
        user.setAddress(address);
        user.setPostcode(postcode);
        user.setPhoneNumber(phone_number);

        try {
            UserFacade.updateUser(connectionPool, user);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
    }
}
