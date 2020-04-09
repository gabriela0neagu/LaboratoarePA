import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlbumsController implements AlbumsDao {
    @Override
    public void create(String name, int artistId, int releaseYear) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO albums(id, name, artist_id, release_year) VALUES(?,?,?,?)");
            Random random = new Random();
            statement.setInt(1, random.nextInt(1000));
            statement.setString(2, name);
            statement.setInt(3, artistId);
            statement.setInt(4, releaseYear);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> findByArtist(int artistId) {
        Connection connection = Database.getConnection();
        List<Integer> albums = new ArrayList<Integer>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM albums WHERE artist_id = '" + artistId + "'");
            while (resultSet.next()) {
                albums.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }
}
