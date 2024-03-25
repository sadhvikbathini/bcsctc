import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/oshp";
    private static final String USER = "root";
    private static final String PASS = "pass";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}

