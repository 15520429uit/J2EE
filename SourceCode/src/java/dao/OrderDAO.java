package dao;

import bean.Order;
import bean.Product;
import static dao.DBConnection.getCon;
import java.sql.*;
import java.util.*;

public class OrderDAO extends DBConnection
{
    public static int addOrder(Order order) 
    {
        int status = 0;
        Connection conn = getCon();
        try
        {
            PreparedStatement ps = conn.prepareStatement("Insert into ShopOrder (ProductId, Username, OrderValue) values(?, ?)");
            ps.setLong(1, order.ProductId);
            ps.setString(2, order.Username);
            ps.setInt(3, order.OrderValue);
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {}
        return status;
    }
    
    public static ArrayList<Order> getAll()
    {
        ArrayList<Order> result = new ArrayList<Order>();
        Connection conn = getCon();
        try
        {
            ResultSet rs = conn.prepareStatement("Select * from ShopOrder").executeQuery();
            while(rs.next())
                result.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getInt(5)));
            conn.close();
        } catch (SQLException ex) {}
        return result;
    }
}
