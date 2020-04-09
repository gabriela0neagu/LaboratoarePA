import java.sql.*;
import java.util.Random;

public class ArtistsController implements ArtistsDao {
    @Override
    public void create(String name, String country) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO artists(id, name, country) VALUES(?,?,?)");
            Random random = new Random();
            statement.setInt(1, random.nextInt(1000));
            statement.setString(2, name);
            statement.setString(3, country);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int findByName(String name) {
        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT id FROM artists WHERE name = '" + name + "'");
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next())
                return resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
