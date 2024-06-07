import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Artist {

    // Properties
    private String artistId;
    private String name;
    private String email;
    private List<Album> albums;

    // Constructor
    public Artist(String artistId, String name, String email) {
        this.artistId = artistId;
        this.name = name;
        this.email = email;
        this.albums = new ArrayList<>();
    }

    // Getters and Setters

    public String getArtistId() {
        return this.artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Album> getAlbums() {
        return this.albums;
    }

    // Methods
    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    @Override
    public String toString() {
        String albumTitles = this.albums.stream()
                .map(Album::getTitle)
                .collect(Collectors.joining(", "));
        return
            "Artist {\n" +
                "\tartistId = '" + this.artistId + "',\n" +
                "\tname = '" + this.name + "',\n" +
                "\temail = " + this.email + ",\n" +
                "\talbums = [" + albumTitles + "]" +
            "\n}";
    }
}
