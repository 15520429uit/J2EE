import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null)
        {
            for(Cookie cookie : cookies)
            {
    		if(cookie.getName().equals("JSESSIONID"))
                {
                    System.out.println("JSESSIONID="+cookie.getValue());
    		}
    		cookie.setMaxAge(0);
    		response.addCookie(cookie);
            }
    	}
    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	System.out.println("User="+session.getAttribute("user"));
    	if(session != null)
            session.invalidate();
    	//no encoding because we have invalidated the session
    	response.sendRedirect("index.jsp");
    }
}
