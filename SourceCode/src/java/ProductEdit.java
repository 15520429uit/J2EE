import dao.ProductDAO;
import bean.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class ProductEdit extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Product product = ProductDAO.getProductById(Integer.parseInt(request.getParameter("id")));
        if(product != null)
        {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product_edit.jsp").forward(request, response);
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
        long id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String name = (String)request.getParameter("name");
        String category = (String)request.getParameter("category");
        String description = (String)request.getParameter("description");
        Part filepart = request.getPart("photo");
        
        if(price < 0 || quantity < 0)
        {
            request.setAttribute("message", "Price and quantity must be non-negative");
            request.setAttribute("product", ProductDAO.getProductById(id));
            request.getRequestDispatcher("product_edit.jsp").forward(request, response);
            return;
        }
        if(filepart != null && filepart.getSize() != 0)
        {
            String filetype = filepart.getContentType();
            if (!filetype.contains("image"))
            {
                request.setAttribute("message", "Only support image file type");
                request.setAttribute("product", ProductDAO.getProductById(id));
                request.getRequestDispatcher("product_edit.jsp").forward(request, response);
                return;
            }
            else
                ProductDAO.editProductImage(id, filepart.getInputStream(), filetype);
        }
        ProductDAO.updateProduct(new Product(id, name, price, quantity, category, description, null, ""));
        response.sendRedirect("ProductList");
    }
}
