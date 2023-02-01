package model;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection
{

    public static Connection getConnection()
    {
        Connection connection = null;
        Statement statement;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectDatabase", "root", "");
            connection.setAutoCommit(true);
            statement = connection.createStatement();

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

}
