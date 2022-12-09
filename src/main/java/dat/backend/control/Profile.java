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

@WebServlet(name = "profile", value = "/profile")
public class Profile extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Update user password
        String password = request.getParameter("password");
        String password2 = request.getParameter("password1");
        if (password.equals(password2)) {
            User user = (User) request.getSession().getAttribute("user");
            user.setPassword(password);
            try {
                UserFacade.updateUserPassword(connectionPool, user);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);

    }
}
