import java.util.List;

public interface AlbumsDao {
    public void create(String name, int artistId, int releaseYear);

    List<Integer> findByArtist(int artistId);
}
