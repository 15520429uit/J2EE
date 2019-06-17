import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        
        if(username.isEmpty() || password.isEmpty())
        {
            request.getSession().setAttribute("header_message", "Password and username is required");
            response.sendRedirect(request.getHeader("Referer"));
        }
        else if(UserDAO.validateUser(username, password))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(30*60);
            if(UserDAO.getUser(username).IsAdmin || username == "admin")
                session.setAttribute("admin", "true");
            else
                session.removeAttribute("admin");
            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            request.getSession().setAttribute("header_message", "Login failed!");
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
