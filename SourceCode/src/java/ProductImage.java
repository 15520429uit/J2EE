import dao.ProductDAO;
import bean.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductImage extends HttpServlet
{   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        long id = Integer.parseInt(request.getParameter("id"));
        Product product_image = ProductDAO.getProductById(id);
        response.setContentType(product_image.Image_type);
        response.setHeader("Content-Type", product_image.Image_type);
        response.setHeader("Content-Length", String.valueOf(product_image.Image.length));
        response.getOutputStream().write(product_image.Image);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
