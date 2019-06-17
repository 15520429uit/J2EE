import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class UserList extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(request.getSession().getAttribute("admin") != null)
        {
            request.setAttribute("list", UserDAO.getAll());
            request.setAttribute("list_length", UserDAO.getAll().size());
            request.getRequestDispatcher("user_list.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doGet(request, response);
    }
}
