import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Users
        User[] users = {
                new User("U001", "John Smith", "john@example.com"),
                new User("U002", "Emily Johnson", "emily@example.com"),
                new User("U003", "Michael Brown", "michael@example.com"),
                new User("U004", "Emma Davis", "emma@example.com"),
                new User("U005", "William Wilson", "william@example.com"),
                new User("U006", "Olivia Taylor", "olivia@example.com"),
                new User("U007", "James Martinez", "james@example.com"),
                new User("U008", "Sophia Anderson", "sophia@example.com"),
                new User("U009", "Alexander Thomas", "alexander@example.com"),
                new User("U010", "Charlotte White", "charlotte@example.com"),
        };

        // Artists
        Artist[] artists = {
                new Artist("A001", "Queen", "queen@example.com"),
                new Artist("A002", "The Beatles", "beatles@example.com"),
                new Artist("A003", "Led Zeppelin", "ledzeppelin@example.com"),
                new Artist("A004", "Michael Jackson", "michaeljackson@example.com"),
                new Artist("A005", "Nirvana", "nirvana@example.com")
        };

        // Tracks
        Track[] tracks = {
                new AudioTrack("T001", "Bohemian Rhapsody", 354, "High"),
                new AudioTrack("T002", "Hotel California", 391, "High"),
                new AudioTrack("T003", "Stairway to Heaven", 482, "High"),
                new AudioTrack("T004", "Imagine", 185, "High"),
                new AudioTrack("T005", "Hey Jude", 431, "High"),
                new AudioTrack("T006", "Yesterday", 158, "High"),
                new AudioTrack("T007", "Smells Like Teen Spirit", 302, "High"),
                new AudioTrack("T008", "Billie Jean", 294, "High"),
                new AudioTrack("T009", "Like a Rolling Stone", 371, "High"),
                new AudioTrack("T010", "Let It Be", 243, "High"),
                new VideoTrack("T011", "Thriller", 389, "1080p"),
                new VideoTrack("T012", "November Rain", 537, "720p"),
                new VideoTrack("T013", "Bohemian Rhapsody (Live Aid)", 387, "1080p"),
                new VideoTrack("T014", "Smells Like Teen Spirit (Live)", 273, "720p"),
                new VideoTrack("T015", "Imagine", 229, "480p"),
                new VideoTrack("T016", "Hotel California (Live)", 373, "1080p"),
                new VideoTrack("T017", "Stairway to Heaven (Live)", 481, "720p"),
                new VideoTrack("T018", "Hey Jude (Live)", 458, "1080p"),
                new VideoTrack("T019", "Yesterday (Live)", 211, "720p"),
                new VideoTrack("T020", "Billie Jean (Live)", 318, "1080p"),
        };

        // Creating an album for artist Queen
        Album album = new Album("ALB001", "TheBest", artists[0], 2024);

        // Artist adds the album
        artists[0].addAlbum(album);

        // Making a playlist
        Playlist playlist = new Playlist("P001", "TheGreatestPlaylist", users[0]);

        // Adding tracks to the playlist
        for(int i = 0; i <= 9 /*15 for checking exception*/; i++) {
            try {
                playlist.addTrack(tracks[i]);
            } catch (PlaylistFullException e) {
                System.out.println(e.getMessage());
            } catch (TrackIdRepeatingException e) {
                System.out.println(e.getMessage());
            }
        }

        // Trying to add the same track (Exception)
        try {
            playlist.addTrack(tracks[0]);
        } catch (PlaylistFullException e) {
            System.out.println(e.getMessage());
        } catch (TrackIdRepeatingException e) {
            System.out.println(e.getMessage());
        }

        // Printing all tracks in the playlist
//        System.out.println(playlist.toString());

        // User adds to playlist and prints
        users[1].addPlaylist(playlist);
//        System.out.println(users[1].toString());

        // Adding tracks to album
        try {
            for(int i = 0; i < 5; i ++) {
                album.addTrack(tracks[i]);
            }

            // Printing all tracks
//            album.getTracks().forEach(track -> System.out.println(track.toString()));

            // Printing the album content
//            System.out.println("\nAll album data:\n" + album.toString());
        } catch (TrackIdRepeatingException e) {
            System.out.println(e.getMessage());
        }

        // Filtering tracks by duration (<= 250sec)
        Predicate<Track> filterAlbumByDuration = t -> t.getDuration() <= 250;
        System.out.println(album.getTracks().stream()
                .filter(filterAlbumByDuration)
                .collect(Collectors.toList()));
    }
}