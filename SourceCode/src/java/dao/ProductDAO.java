package dao;

import bean.Product;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ProductDAO extends DBConnection
{
    public static int addProduct(Product product)
    {
        int status = 0;
        if(product.Name.trim().isEmpty())
            return status;
        try
        {
            PreparedStatement ps = getCon().prepareStatement("Insert into PRODUCT (NAME, PRICE, QUANTITY, CATEGORY, DESCRIPTION) values(?, ?, ?, ?, ?)");
            ps.setString(1, product.Name);
            ps.setInt(2, product.Price);
            ps.setInt(3, product.Quantity);
            ps.setString(4, product.Category);
            ps.setString(5, product.Description);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                status = rs.getInt("ID");
            ps.close();
            rs.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return status;
    }
    
    
    public static int updateProduct(Product product)
    {
        int status = 0;
        try
        {
            PreparedStatement ps = getCon().prepareStatement("Update PRODUCT set Name=?, Price=?, Quantity=?, Category=?, Description=? where ID=?");
            ps.setString(1, product.Name);
            ps.setInt(2, product.Price);
            ps.setInt(3, product.Quantity);
            ps.setString(4, product.Category);
            ps.setString(5, product.Description);
            ps.setLong(6, product.Id);
            status = ps.executeUpdate();
            ps.close();
        }
        catch(Exception ex) { System.out.println(ex); }
        return status;
    }
    
    public static int deleteProduct(long id)
    {
        int status = 0;
        try
        {
            status = getCon().prepareStatement("Delete from PRODUCT where ID=" + id).executeUpdate();
        }
        catch(Exception ex) { System.out.println(ex); }
        return status;
    }
    
    public static Product getProductById(long id)
    {
        Product product = null;
        try
        {
            PreparedStatement ps = getCon().prepareStatement("Select * from PRODUCT where ID=?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                product = new Product();
                product.Id = id;
                product.Name = rs.getString("NAME");
                product.Price = rs.getInt("PRICE");
                product.Quantity = rs.getInt("QUANTITY");
                product.Category = rs.getString("CATEGORY");
                product.Description = rs.getString("DESCRIPTION");
                product.Image = rs.getBytes("IMAGE");
                product.Image_type = rs.getString("IMAGE_TYPE");
            }
        }
        catch(Exception ex) { System.out.println(ex); }
        return product;
    }
    
    public static int editProductImage(long id, InputStream input_stream, String image_type)
    {
        int status = 0;
        try
        {
            PreparedStatement ps = getCon().prepareStatement("Update PRODUCT set Image=?, IMAGE_TYPE=? where ID=?");
            ps.setBinaryStream(1, input_stream);
            ps.setString(2, image_type);
            ps.setLong(3, id);
            status = ps.executeUpdate();
        }
        catch(Exception ex) { System.out.println(ex); }
        return status;
    }
    
    public static List<Product> getAllProducts()
    {
        List<Product> list = new LinkedList<>();
        try
        {
            ResultSet rs = getCon().prepareStatement("Select * from PRODUCT").executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.Id = rs.getLong("ID");
                product.Name = rs.getString("NAME");
                product.Price = rs.getInt("PRICE");
                product.Quantity = rs.getInt("QUANTITY");
                product.Category = rs.getString("CATEGORY");
                product.Description = rs.getString("DESCRIPTION");
                list.add(product);
            }
        }
        catch(Exception ex) { System.out.println(ex); }
        return list;
    }
    
    public static List<Product> getByCategory(String category)
    {
        List<Product> list = new LinkedList<>();
        try
        {
            PreparedStatement ps = getCon().prepareStatement("Select ID, NAME, PRICE, QUANTITY, DESCRIPTION from PRODUCT where category = ?");
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.Id = rs.getLong("ID");
                product.Name = rs.getString("NAME");
                product.Price = rs.getInt("PRICE");
                product.Quantity = rs.getInt("QUANTITY");
                product.Category = category;
                product.Description = rs.getString("DESCRIPTION");
                list.add(product);
            }
        }
        catch(Exception ex) { System.out.println(ex); }
        return list;
    }
    
//    public static void main(String[] args)
//    {
//        try
//        {
//            Connection conn = getCon();
//            PreparedStatement ps = conn.prepareStatement("Update PRODUCT set Image=? where ID=1");
//
//            
//            BufferedImage img = (ImageIO.read(new URL("https://dictionary.cambridge.org/images/thumb/book_noun_001_01679.jpg")));
//            FileInputStream fis;
//            File file = new File("download.jpg");
//            ImageIO.write(img, "jpg", file);
//            fis = new FileInputStream(file); 
//            ps.setBinaryStream(1, (InputStream)fis, (int)(file.length()));
//            ps.executeUpdate();
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//            System.out.println(ex);
//        }
//
//    }
}
