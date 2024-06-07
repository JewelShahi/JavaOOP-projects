import java.util.ArrayList;
import java.util.List;

public class Album {

    // Properties
    private String albumId;
    private String title;
    private Artist artist;
    private int releaseYear;
    private List<Track> tracks;

    // Constructor
    public Album(String albumId, String title, Artist artist, int releaseYear) {
        this.albumId = albumId;
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.tracks = new ArrayList<>();
    }

    // Getters and Setters

    public String getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    // Methods
    public void addTrack(Track track) throws TrackIdRepeatingException {
        if(this.tracks.contains(track))
            throw new TrackIdRepeatingException("The track with ID: '" + track.getTrackId() + "' is already added to the album.");
        this.tracks.add(track);
    }

    @Override
    public String toString() {
        return
           "Album {\n" +
              "\talbumId = '" + this.albumId + "',\n" +
              "\ttitle ='" + this.title + "',\n" +
              "\tartist = " + this.artist + ",\n" +
              "\treleaseYear = " + this.releaseYear + ",\n"+
              "\ttracks = " + this.tracks +
           "\n}";
    }
}
