package bean;

public class Product
{
    public long Id = 0;
    public int Price = 0;
    public int Quantity = 0;
    public String Name = "";
    public String Category = "";
    public String Description = "";
    public byte[] Image = null;
    public String Image_type = null;

    public Product() {}
    public Product(String name, int price, int quantity)
    {
        Name = name;
        Price = price;
        Quantity = quantity;
    }
    
    public Product(String name, int price, int quantity, String category, String description)
    {
        Name = name;
        Price = price;
        Quantity = quantity;
        Category = category;
        Description = description;
    }
    
    public Product(long id, String name, int price, int quantity, String category, String description, byte[] image, String format)
    {
        Id = id;
        Name = name;
        Price = price;
        Quantity = quantity;
        Category = category;
        Description = description;
        Image = image;
        Image_type = format;
    }

    public long getId() {return Id;}
    public int getPrice() {return Price;}
    public int getQuantity() {return Quantity;}

    public String getName() {return Name;}
    public String getCategory() {return Category;}
    public String getDescription() {return Description;}
}
