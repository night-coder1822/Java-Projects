package student_management_system;

import java.sql.*;

public class Conn
{
    Connection c;
    Statement s;
    
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITY_MANAGEMENT_SYSTEM", "","");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
