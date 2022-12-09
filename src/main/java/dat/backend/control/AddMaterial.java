package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addmaterial", value = "/addmaterial")
public class AddMaterial extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String unit = request.getParameter("unit");
        double unit_price = Double.parseDouble(request.getParameter("unit_price"));

        MaterialFacade.addMaterial(new Material(description, type, unit, unit_price), connectionPool);

        List<Material> materialList = null;
        try {
            materialList = MaterialFacade.getAllMaterials(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("materialList", materialList);

        List<Material> woodList = null;
        try {
            woodList = MaterialFacade.getAllWood(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("woodList", woodList);

        List<Material> accessoryList = null;
        try {
            accessoryList = MaterialFacade.getAllAccessory(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("accessoryList", accessoryList);

        request.getRequestDispatcher("WEB-INF/itemlist.jsp").forward(request, response);
    }
}
