import java.sql.*;

public class DBConnectivity {

    public static Connection getPostgresConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Aryan_Mart",
                "postgres",
                "Modiii@2k6");
    }


}
