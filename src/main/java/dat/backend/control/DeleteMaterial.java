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

@WebServlet(name = "deletematerial", value = "/deletematerial")
public class DeleteMaterial extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //Delete material
        int material_id = Integer.parseInt(request.getParameter("material_id"));
        MaterialFacade.deleteMaterial(material_id, connectionPool);

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
