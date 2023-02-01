package model;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Operations
{
    private static ResultSet result;
    private static ArrayList<String> valuesInDB = new ArrayList<String>();
    private static String value = "";

    public static LocalDate getCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

    public static void insert(String kind, String type, String address, double sum, String donateDate, String repete, String same)
    {
        String query = " insert into donor (personKind, type, address, sum, date, repeating, same)"
                + " values ('"+kind+"','"+type+"','"+address+"','"+sum+"','"+donateDate+"','"+repete+"','"+same+"')";
        PreparedStatement preparedStmt = null;

        try
        {
            preparedStmt = DatabaseConnection.getConnection().prepareStatement(query);
            preparedStmt.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static void update(String categorie, int DonatedAmount, String location,String denotType)
    {
        try {
            String sql = "UPDATE  dones set " +
                         "type = '" + denotType + "' , " +
                         "Amount = '" + DonatedAmount + "'  " +
                         " WHERE  categorie = '" + categorie+"'"+
                         " AND location = '"+location+"'";
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
