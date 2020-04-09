import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        ArtistsController artistsController = new ArtistsController();
        AlbumsController albumsController = new AlbumsController();

        artistsController.create("Lady Gaga", "USA");
        artistsController.create("Eminem", "SUA");

        int eminemId = artistsController.findByName("Eminem");
        System.out.println(eminemId);

        albumsController.create("Kamikaze", eminemId, 2018);
        albumsController.create("Music To Be MurderedBy", eminemId, 2020);
        albumsController.create("A star is born", artistsController.findByName("Lady Gaga"), 2018);

        List<Integer> results = new ArrayList<Integer>();
        results = albumsController.findByArtist(eminemId);

        for (Integer id : results)
            System.out.print(id + " ");

    }
}
