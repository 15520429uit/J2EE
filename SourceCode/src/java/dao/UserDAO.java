package dao;

import bean.User;
import java.sql.*;
import java.util.*;

public class UserDAO extends DBConnection
{
    public static int addUser(User user)
    {
        int status = 0;
        if(user.Name.trim().isEmpty() || user.Password.trim().isEmpty())
            return status;
        try
        {
            Connection conn = getCon();
            PreparedStatement ps = conn.prepareStatement("Insert into UserAccount values(?, ?)");
            ps.setString(1, user.Name);
            ps.setString(2, user.Password);
            status = ps.executeUpdate();
            conn.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return status;
    }
          
    public static User getUser(String name)
    {
        User user = null;
        try
        {
            Connection conn = getCon();
            PreparedStatement ps = conn.prepareStatement("Select * from UserAccount where NAME=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                user = new User();
                user.Name = rs.getString(1);
                user.Password = rs.getString(2);
                user.IsAdmin = rs.getBoolean(3);
            }
            conn.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return user;
    }
    
    public static boolean validateUser(String name, String pass)
    {
        boolean result = false;
        try
        {
            Connection conn = getCon();
            PreparedStatement ps = conn.prepareStatement("Select * from UserAccount where NAME=? and PASSWORD=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            if(ps.executeQuery().next())
                result = true;
            conn.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return result;
    }
    
    public static List<User> getAll()
    {
        List<User> list = new LinkedList<>();
        try
        {
            Connection conn = getCon();
            ResultSet rs = conn.prepareStatement("Select * from UserAccount").executeQuery();
            while(rs.next())
            {
                User user = new User();
                user.Name = rs.getString(1);
                user.Password = rs.getString(2);
                user.IsAdmin = rs.getBoolean(3);
                list.add(user);
            }
            conn.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return list;
    }
    
    public static int editUser(User user)
    {
        int status = 0;
        if(user.Name.trim().isEmpty() || user.Password.trim().isEmpty())
            return status;
        try
        {
            Connection conn = getCon();
            PreparedStatement ps = conn.prepareStatement("Update UserAccount set Password=?, IsAdmin=?, IsActive=? where Name=?");
            ps.setString(1, user.Password);
            ps.setBoolean(2, user.IsAdmin);
            ps.setBoolean(3, user.IsActive);
            ps.setString(4, user.Name);
            status = ps.executeUpdate();
            conn.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return status;
    }
}
