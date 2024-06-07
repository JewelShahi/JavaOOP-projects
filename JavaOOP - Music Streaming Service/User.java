import java.util.ArrayList;
import java.util.List;

public class User {

    // Properties
    private String userId;
    private String name;
    private String email;
    private List<Playlist> playlists;

    // Constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    // Methods
    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    @Override
    public String toString() {
        return
           "User {\n" +
              "\tuserId = '" + this.userId + "',\n" +
              "\tname = " + this.name + ",\n" +
              "\temail = " + this.email + ",\n" +
              "\tplaylists = " + this.playlists +
           "\n}";
    }
}
