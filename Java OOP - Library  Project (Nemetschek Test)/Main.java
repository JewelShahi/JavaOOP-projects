class Main {
  public static void main(String[] args) {
    BookManager manager = new BookManager();
    manager.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", "1925"));
    manager.addBook(new Book("Pride and Prejudice", "Jane Austen", "Classic", "1813"));
    manager.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", "1960"));
    manager.addBook(new Book("1984", "George Orwell", "Science fiction", "1949"));
    manager.addBook(new Book("Brave New World", "Aldous Huxley", "Science fiction", "1932"));
    manager.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", "1997"));
    manager.addBook(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science fiction", "1979"));
    manager.addBook(new Book("The Da Vinci Code", "Dan Brown", "Thriller", "2003"));
    manager.addBook(new Book("Daughter of Fortune", "Isabel Allende", "Historical fiction", "1999"));
    manager.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Classic", "1951"));
    System.out.println("\033[H\033[2J\033[1;31mAll books:\033[0m");
    manager.printBooks();

    System.out.println("\n\n--------------Sorting books--------------\n");
    
    System.out.println("\n\033[1;31mBooks sorted by author:\033[0m");
    manager.sortBooksByAuthor();
    manager.printBooks();
    
    System.out.println("\n\033[1;31mBooks sorted by title:\033[0m");
    manager.sortBooksByTitle();
    manager.printBooks();
    
    System.out.println("\n\033[1;31mBooks sorted by genre:\033[0m");
    manager.sortBooksByGenre();
    manager.printBooks();
    
    System.out.println("\n\033[1;31mBooks sorted with priority:\033[0m");
    manager.sortBooksByTitleWithPriority();
    manager.printBooks();
  }
}
