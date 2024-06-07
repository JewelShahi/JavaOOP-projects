/**
 * User
 */

// Imports
import java.util.List;
import java.util.ArrayList;

public class User {

	private int userID;
	private String name;
	private String email;
	private boolean subscriptionStatus;
	private List<Movie> watchlist;

	// Constructor
	public User(int userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.subscriptionStatus = false;
		this.watchlist = new ArrayList<Movie>();
	}

	// Adding movie to the watchlist
	public void addToWatchlist(Movie movie) {
		this.watchlist.add(movie);
	}

	// Getting the WatchList
	public List<Movie> getWatchlist(){
		return this.watchlist;
	}
	// Rating movie
	public void rateMovie(Movie movie, double rating) {
		movie.updateRating(rating);
	}

	// Manage Subscription
	public void manageSubscription(boolean subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public void receiveRecommendations(List<Movie> recommendations) {
		for (Movie movie : recommendations) {
			System.out.println(movie.getMovieDetails());
		}
	}

	@Override
	public String toString() {
		return 
		"User {\n" +
			"\tid = " + this.userID + ",\n" +
			"\tname = '" + this.name + "',\n" +
			"\temail = '" + this.email + "'\n" +
			"\tsubscriptionStatus = '" + this.subscriptionStatus + "'\n" +
		"}\n";
	}
}
