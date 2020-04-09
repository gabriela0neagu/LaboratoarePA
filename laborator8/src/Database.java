import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database database = new Database();
    private static Connection connection = null;

    private Database() {
    }

    public static Database getInstance() {
        return database;
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = estabilishConnection();
        }
        return connection;
    }

    private static Connection estabilishConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dba", "sql");
            System.out.println("Succesfully connected");

        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    private static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
