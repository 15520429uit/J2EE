package bean;

import java.sql.Date;


public class Order {
    
    public long Id;
    public long ProductId;
    public String Username;
    public Date OrderDate;
    public int OrderValue;

    public Order(long ProductId, String Username, int OrderValue) {
        this.Username = Username;
        this.ProductId = ProductId;
        this.OrderValue = OrderValue;
    }

    public Order(long Id, long ProductId, String Username, Date OrderDate, int OrderValue) {
        this.Id = Id;
        this.Username = Username;
        this.ProductId = ProductId;
        this.OrderDate = OrderDate;
        this.OrderValue = OrderValue;
    }

    public long getId() {
        return Id;
    }

    public long getProductId() {
        return ProductId;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public String getUsername() {
        return Username;
    }

    public int getOrderValue() {
        return OrderValue;
    }
    
}
