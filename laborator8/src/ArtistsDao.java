import java.util.List;

public interface ArtistsDao {
    public void create(String name, String country);

    public int findByName(String name);
}
