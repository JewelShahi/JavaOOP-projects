import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static IDisplay displayMovies = (Movie[] mov) -> Arrays
            .stream(mov)
            .forEach(
                    m -> System.out.println(m.getMovieDetails()));

    public static IFilterMovie<Movie[], String> filterByTitle = (Movie[] movies, String title) -> Arrays
            .stream(movies)
            .filter(m -> m.getTitle().equalsIgnoreCase(title))
            .forEach(m -> System.out.println(m.getMovieDetails()));

    public static IFilterMovie<Movie[], Boolean> filterByAvailability = (Movie[] movies, Boolean isAvailable) -> Arrays
            .stream(movies)
            .filter(m -> m.getIsAvailable() == isAvailable)
            .forEach(m -> System.out.println(m.getMovieDetails()));

    public static void main(String[] args) {

        // Data
        Movie[] movies = {
                new Movie(1, "Inception", "Sci-Fi", 148, 2010, 8.8, true),
                new Movie(2, "The Shawshank Redemption", "Drama", 142, 1994, 9.3, true),
                new Movie(3, "The Godfather", "Crime", 175, 1972, 9.2, false),
                new Movie(4, "The Dark Knight", "Action", 152, 2008, 9.0, true),
                new Movie(5, "Pulp Fiction", "Crime", 154, 1994, 8.9, true),
                new Movie(6, "Schindler's List", "Biography", 195, 1993, 9.0, false),
                new Movie(7, "The Lord of the Rings: The Return of the King", "Fantasy",
                        201, 2003, 8.9, true),
                new Movie(8, "Fight Club", "Drama", 139, 1999, 8.8, false),
                new Movie(9, "Forrest Gump", "Drama", 142, 1994, 8.8, true),
                new Movie(10, "The Matrix", "Sci-Fi", 136, 1999, 8.7, true)
        };

        User user = new User(1, "Joe", "joe@joe.com");

        System.out.println("Add movie to watchlist:");
        IWatchlist addToWatchlist = user::addToWatchlist;
        addToWatchlist.add(movies[0]);
        addToWatchlist.add(movies[7]);
        addToWatchlist.add(movies[5]);
        user.getWatchlist()
                .forEach(movie -> System.out.println(movie.getMovieDetails()));

        System.out.println("Filter by title:");
        filterByTitle.filter(movies, "Inception");

        System.out.println("Rating a movie:");
        IRate rateMovie = user::rateMovie;
        rateMovie.rate(movies[0], 7.9);
        filterByTitle.filter(movies, "Inception");

        System.out.println("Movie searche by availability:");
        filterByAvailability.filter(movies, false);

        System.out.println("Managing user subscription:");
        ISubscription subscribe = user::manageSubscription;
        subscribe.manageSubscription(true);
        System.out.println(user.toString());

        System.out.println("User recommendations:");
        List<Movie> recommendations = Arrays.stream(movies).filter(m -> m.getGenre().equalsIgnoreCase("Crime"))
                .collect(Collectors.toList());
        user.receiveRecommendations(recommendations);
    }
}
