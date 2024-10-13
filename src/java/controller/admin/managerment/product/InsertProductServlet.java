
package controller.admin.managerment.product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import DAO.TypeDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Supplier;
import model.Type;


@WebServlet(name = "InsertProductServlet", urlPatterns = {"/InsertProductServlet"})
public class InsertProductServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "view/jsp/admin/admin_products_insert.jsp";
        try {
            String action = request.getParameter("action");
            ProductDAO pDao = new ProductDAO();
            if (action != null) {
                CategoryDAO cDao = new CategoryDAO();
                SupplierDAO sDao = new SupplierDAO();
                TypeDAO tDao = new TypeDAO();

                List<Category> listCategories = cDao.getData();
                List<Supplier> listSuppliers = sDao.getData();
                List<Type> listTypes = tDao.getAllType();

                request.setAttribute("LIST_SUPPLIERS", listSuppliers);
                request.setAttribute("LIST_TYPES", listTypes);
                request.setAttribute("LIST_CATEGORIES", listCategories);
            } else {
                String name = request.getParameter("product_name");
                String price_raw = request.getParameter("price");
                String size = request.getParameter("size");
                String color = request.getParameter("color");
                String stock_raw = request.getParameter("stock");
                String[] images = request.getParameterValues("product_img");
                String description = request.getParameter("description");
                String cid_raw = request.getParameter("category_id");
                String sid_raw = request.getParameter("supplier_id");
                String tid_raw = request.getParameter("type_id");
                String date = request.getParameter("date");
                String discount_raw = request.getParameter("discount");

                int cId = Integer.parseInt(cid_raw);
                int sId = Integer.parseInt(sid_raw);
                int tId = Integer.parseInt(tid_raw);
                int stock = Integer.parseInt(stock_raw);
                double price = Double.parseDouble(price_raw);
                double discount = Double.parseDouble(discount_raw);
                String image = "";
                if (images[0] != null && !images[0].equals("")) {
                    for (int i = 0; i < images.length; i++) {
                        image += "view/assets/home/img/products/" + images[i] + " ";
                    }
                }
                
                pDao.insertProduct(name, cId, sId, tId, price, discount, size, color, stock, date, image, description);
                
                request.setAttribute("mess", "Insert successfully!");
                url = "ManageProductServlet";
            }
        } catch (Exception ex) {
            log("InsertProductServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
