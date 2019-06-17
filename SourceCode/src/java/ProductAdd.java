import dao.ProductDAO;
import bean.Product;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class ProductAdd extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("product_add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name").trim();
        String s_price = request.getParameter("price").trim();
        String s_quantity = request.getParameter("quantity").trim();
        String category = (String)request.getParameter("category");
        String description = (String)request.getParameter("description");
        Part filepart = request.getPart("photo");
        
        if(name.isEmpty() || s_price.isEmpty() || s_quantity.isEmpty())
        {
            request.setAttribute("message", "Name, price and quantity is required");
            request.getRequestDispatcher("product_add.jsp").forward(request, response);
            return;
        }
        int price = Integer.parseInt(s_price);
        int quantity = Integer.parseInt(s_quantity);
        if(price < 0 || quantity < 0)
        {
            request.setAttribute("message", "Price and quantity must be non-negative");
            request.getRequestDispatcher("product_edit.jsp").forward(request, response);
            return;
        }
        else
        {
            if(filepart != null && filepart.getSize() != 0)
            {
                String filetype = filepart.getContentType();
                if (!filetype.contains("image"))
                {
                    request.setAttribute("message", "Only support image file type");
                    request.getRequestDispatcher("product_edit.jsp").forward(request, response);
                    return;
                }
                else
                {
                    int id = ProductDAO.addProduct(new Product(name, price, quantity, category, description));
                    ProductDAO.editProductImage(id, filepart.getInputStream(), filetype);
                }
            }
            else
                ProductDAO.addProduct(new Product(name, price, quantity, category, description));
            response.sendRedirect("ProductList.jsp");
        }
    }
}
