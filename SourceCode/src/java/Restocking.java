import bean.Cart;
import bean.Order;
import bean.PhieuNhap;
import bean.Product;
import dao.PhieuNhapDAO;
import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Restocking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", ProductDAO.getAllProducts());
        request.getRequestDispatcher("restocking.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Product product = ProductDAO.getProductById(Integer.parseInt(request.getParameter("product_id")));
        int so_luong_nhap = Integer.parseInt(request.getParameter("so_luong_nhap"));
        
        if(product == null)
        {
            session.setAttribute("header_message", "San pham khong ton tai");
            response.sendRedirect(request.getHeader("Referer"));
        }
        else
        {
            product.Quantity += so_luong_nhap;
            ProductDAO.updateProduct(product);
            PhieuNhapDAO.addPhieuNhap(new PhieuNhap(product.Id, so_luong_nhap, product.Price * so_luong_nhap));
            session.setAttribute("header_message", "Them san pham thanh cong");
            response.sendRedirect(request.getHeader("Referer"));
        }
    }


}
