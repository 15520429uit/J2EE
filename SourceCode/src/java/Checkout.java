import bean.Cart;
import bean.Order;
import bean.Product;
import dao.OrderDAO;
import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Checkout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String)session.getAttribute("user");
        Cart cart = (Cart)session.getAttribute("cart");
        
        if(username == null || username.trim().isEmpty())
        {
            request.getSession().setAttribute("header_message", "You had to login to checkout");
            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            if(cart != null)
            {
                for (Product product : cart.getProduct_list())
                {
                    product.Quantity--;
                    ProductDAO.updateProduct(product);
                }
                for (Product product : cart.getProduct_list()) 
                    OrderDAO.addOrder(new Order(product.Id, username, product.Price));
                session.setAttribute("cart", new Cart());
                request.setAttribute("cart_order", cart);
            }
            request.getRequestDispatcher("cart_order.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
