package bean;

import java.sql.Date;


public class PhieuNhap {
    
    public long MaPhieuNhap;
    public long ProductId;
    public Date NgayNhhap;
    public int SoLuongNhap;
    public int TriGia;

    public PhieuNhap(long ProductId, int SoLuongNhap, int TriGia) {
        this.TriGia = TriGia;
        this.ProductId = ProductId;
        this.SoLuongNhap = SoLuongNhap;
    }
}
