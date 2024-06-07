import java.util.ArrayList;
import java.util.List;

public class Playlist implements IPlayable {

    // Properties
    private String playlistId;
    private String name;
    private User creator;
    private List<Track> tracks;
    private int playCount;


    // Constructor
    public Playlist(String playlistId, String name, User creator) {
        this.playlistId = playlistId;
        this.name = name;
        this.creator = creator;
        this.playCount = 0;
        this.tracks = new ArrayList<>();
    }

    // Getters and Setters

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    // Methods
    public void addTrack(Track track) throws PlaylistFullException, TrackIdRepeatingException {
        if(this.tracks.size() > 10)
            throw new PlaylistFullException("Playlist cannot contain more than 10 tracks");
        if(this.tracks.contains(track))
            throw new TrackIdRepeatingException("The track with ID: '" + track.getTrackId() + "' is already added to the playlist.");
        this.tracks.add(track);
    }

    public void incrementPlayCount() {
        this.playCount += 1;
    }

    @Override
    public void play() {
        incrementPlayCount();
        System.out.println("Playing playlist: " + this.name);
        for (Track track : this.tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return
           "Playlist {\n" +
              "\tplaylistId = '" + this.playlistId + "',\n" +
              "\tname = '" + this.name + "',\n" +
              "\tuser = " + this.creator.getName() + ",\n" +
              "\ttracks = " + this.tracks +
           "\n}";
    }
}
