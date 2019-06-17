package bean;

public class User 
{
    public String Name = "";
    public String Password = "";
    public boolean IsAdmin = false;
    public boolean IsActive = true;

    public User() {}
    public User(String name, String password)
    {
        Name = name;
        Password = password;
    }
    public User(String name, String password, boolean is_admin, boolean is_active)
    {
        Name = name;
        Password = password;
        IsAdmin = is_admin;
        IsActive = is_active;
    }
    
    public String getName() {return Name;}
    public String getPassword() {return Password;}
    public boolean getIsAdmin() {return IsAdmin;}
    public boolean getIsActive() {return IsActive;}
}