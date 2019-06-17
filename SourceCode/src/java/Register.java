import dao.UserDAO;
import bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null)
            response.sendRedirect("register.jsp");
        else
            response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String re_pass = request.getParameter("re_password").trim();
        if(username.isEmpty() || password.isEmpty() || re_pass.isEmpty())
        {
            request.setAttribute("message", "Please fill the required infomation");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else if(!password.equals(re_pass))
        {
            request.setAttribute("message", "Password and repeat don't match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else if(UserDAO.getUser(username) != null)
        {
            request.setAttribute("message", "Username not available!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else
        {
            User user = new User(username, password);
            UserDAO.addUser(user);
            request.setAttribute("message", "Registration completed! Please login");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
