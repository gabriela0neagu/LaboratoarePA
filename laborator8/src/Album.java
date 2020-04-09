import java.util.UUID;

public class Album {
    private UUID id;
    private String name;
    private int artistId;
    private int releaseYear;

    Album(String name, int artistId, int releaseYear) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
