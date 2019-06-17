import dao.ProductDAO;
import bean.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class ProductDetails extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Product product = ProductDAO.getProductById(Integer.parseInt(request.getParameter("id")));
        if(product != null)
        {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product_details.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Product id is not available");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
}
