package bankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    Connection c;
    Statement s;

    public DatabaseConnection() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "cyberXpro77");
            s = c.createStatement();

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}



