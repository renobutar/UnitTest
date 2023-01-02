
import java.sql.*;
public class DbConnection {
    private Connection con;

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc","root","@BTRrone1512");
        } catch (Exception e) {
            System.out.println("Error + "+ e.getMessage());
        }
        return con;
    }
}
