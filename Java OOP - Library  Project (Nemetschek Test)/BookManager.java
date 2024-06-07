import java.util.*;
public class BookManager {
  private List<Book> books;

  public BookManager() {
    books = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void printBooks() {
    for (Book book : books) {
      System.out.println(book);
    }
  }

  public void sortBooksByTitle() {
    Collections.sort(books, Comparator.comparing(Book::getTitle));
  }

  public void sortBooksByAuthor() {
    Collections.sort(books, Comparator.comparing(Book::getAuthor));
  }

  public void sortBooksByGenre() {
    Collections.sort(books, Comparator.comparing(Book::getGenre));
  }

  public void sortBooksByTitleWithPriority() {
    Collections.sort(books, Comparator.comparing(Book::getTitle, (s1, s2) -> {
      if (s1.equals("To Kill a Mockingbird")) {
        return -1;
      }
      else if (s2.equals("To Kill a Mockingbird")) {
        return 1;
      } 
      else {
        return s1.compareTo(s2);
      }
    }));
  }
}
