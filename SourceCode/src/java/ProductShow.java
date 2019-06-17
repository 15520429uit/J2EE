import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductShow extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getParameterMap().containsKey("category") && !request.getParameter("category").isEmpty())
            request.setAttribute("list", ProductDAO.getByCategory(request.getParameter("category")));
        else 
            request.setAttribute("list", ProductDAO.getAllProducts());
        request.getRequestDispatcher("product_show.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
