class Book {
  
  private String title;
  private String author;
  private String genre;
  private String publicationDate;
  
  public Book(String title, String author, String genre, String publicationDate) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publicationDate = publicationDate;
  }

	//Getters
  public String getTitle() {
    return this.title;
  }
    
  public String getAuthor() {
    return this.author;
  }
    
  public String getGenre() {
    return this.genre;
  }
    
  public String getPublicationDate() {
    return this.publicationDate;
  }

	//Setters
	public void setTitle(String title) {
    this.title=title;
  }
    
  public void setAuthor(String author) {
    this.author=author;
  }
    
  public void setGenre(String genre) {
    this.genre=genre;
  }
    
  public void setPublicationDate(String publicationDate) {
    this.publicationDate=publicationDate;
  }

  @Override
  public String toString() {
    return this.title + " by " + this.author + ", " + this.genre + ", published on " + this.publicationDate;
  }
}
