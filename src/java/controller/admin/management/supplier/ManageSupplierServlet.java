
package controller.admin.management.supplier;

import DAO.SupplierDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Supplier;


@WebServlet(name = "ManageSupplierServlet", urlPatterns = {"/ManageSupplierServlet"})
public class ManageSupplierServlet extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            SupplierDAO sDao = new SupplierDAO();
            List<Supplier> list = sDao.getData();

            request.setAttribute("LISTSUPPLIERS", list);
            request.setAttribute("action", "MNGSUPPLIER");
            request.setAttribute("CURRENTSERVLET", "Supplier");
        } catch (Exception ex) {
            log("ManageSupplierServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher("view/jsp/admin/admin_suppliers.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
