/**
 * Movie
 */
public class Movie {
	
	private int movieID;
	private String title;
	private String genre;
	private int duration; // in minutes
	private int releaseYear;
	private double rating;
	private boolean isAvailable;

	public Movie(int movieID, String title, String genre, int duration, int releaseYear, double rating, boolean isAvailable){
		this.movieID = movieID;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.isAvailable = isAvailable;
	}

	// MovieID methods
	public void setMovieID(int movieID){
		this.movieID = movieID;
	}

	public int getMovieID(){
		return this.movieID;
	}

	// Title methods
	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	// Genre methods
	public void setGenre(String genre){
		this.genre = genre;
	}

	public String getGenre(){
		return this.genre;
	}

	// Duration methods
	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return this.duration;
	}

	// ReleaseYear methods
	public void setReleaseYear(int releaseYear){
		this.releaseYear = releaseYear;
	}

	public int getReleaseYear(){
		return this.releaseYear;
	}

	// Rating methods
	public void updateRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return this.rating;
	}
	
	// IsAvailable methods
	public void updateAvailability(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	public boolean getIsAvailable(){
		return this.isAvailable;
	}
	
	// Movie details
	public String getMovieDetails(){
		return "Title: " + this.title + "\n" + "Genre: " + this.genre + "\n" + "Duration: " + this.duration + " minutes" + "\n" + "Release Year: " + this.releaseYear + "\n" + "Rating: " + this.rating + "\n";
	}
}
