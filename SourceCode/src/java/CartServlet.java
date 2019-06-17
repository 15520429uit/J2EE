import bean.Cart;
import bean.Product;
import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        if(action == null)
            return;
        switch(action)
        {
            case "add":
                doGet_Add(request, response);
                break;
                
            case "remove":
                doGet_Remove(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
    
    void doGet_Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Product product = ProductDAO.getProductById(Integer.parseInt(request.getParameter("id")));
        if(product != null)
        {
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("cart");
            cart.add(product);
            session.setAttribute("cart", cart);
            response.sendRedirect("index.jsp");
        }
        else
        {
            request.setAttribute("message", "Product id is not available");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("cart");
            cart.remove(Integer.parseInt(request.getParameter("index")) - 1);
            session.setAttribute("cart", cart);
        }
        catch (Exception ex) { }
        response.sendRedirect(request.getHeader("Referer"));
    }
}
