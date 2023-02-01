package model;

public class Donees
{
    private String categorie;
    private String address;


    public Donees() {}
    public Donees(String categorie, String address)
    {
        this.categorie = categorie;
        this.address = address;
    }
    public void setCategorie(String categorie){this.categorie = categorie;}
    public void setAddress(String address){this.address = address;}
    public String getCategorie(){return categorie;}
    public String getAddress(){return address;}

    @Override
    public String toString() {
        return "Donees{" +
                "categorie='" + categorie + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
