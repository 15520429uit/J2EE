import bean.User;
import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        User user = UserDAO.getUser(request.getParameter("name"));
        if(user != null)
        {
            request.setAttribute("user_edit", user);
            request.getRequestDispatcher("user_edit.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Username is not available");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean is_admin = request.getParameter("is_admin") == null;
        boolean is_active = request.getParameter("is_active") == null;
        
        if(password == null || password.trim().isEmpty())
        {
            request.setAttribute("message", "Password is required");
            request.setAttribute("user_edit", UserDAO.getUser(name));
            request.getRequestDispatcher("user_edit.jsp").forward(request, response);
        }
        else
        {
            UserDAO.editUser(new User(name, password, is_admin, is_active));
            response.sendRedirect("UserList");
        }
    }
}
