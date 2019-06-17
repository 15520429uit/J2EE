package bean;


import java.util.ArrayList;

public class Cart 
{
    public ArrayList<Product> product_list = new ArrayList();

    public ArrayList<Product> getProduct_list() {
        return product_list;
    }
    
    public boolean add(Product product)
    {
        product_list.add(product);
        return true;
    };
    
    public boolean remove(int index)
    {
        if(index >= 0 && index < product_list.size())
            product_list.remove(index);
        return true;
    };
    
    public int size()
    {
        return product_list.size();
    }
}
