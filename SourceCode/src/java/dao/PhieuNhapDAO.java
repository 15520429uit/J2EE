package dao;

import bean.PhieuNhap;
import java.sql.*;
import java.util.*;

public class PhieuNhapDAO extends DBConnection
{
    public static int addPhieuNhap(PhieuNhap phieu_nhap) 
    {
        int status = 0;
        Connection conn = getCon();
        try
        {
            PreparedStatement ps = conn.prepareStatement("Insert into PhieuNhap (ProductId, SoLuongNhap, TriGia) values(?, ?, ?)");
            ps.setLong(1, phieu_nhap.ProductId);
            ps.setInt(2, phieu_nhap.SoLuongNhap);
            ps.setInt(3, phieu_nhap.TriGia);
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {}
        return status;
    }
}
