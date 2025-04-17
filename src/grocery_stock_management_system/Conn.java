package grocery_stock_management_system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///grocery_stock", "root", "Abhi0335");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
