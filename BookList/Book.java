package BookList;

public class Book {
  String title, author, publisher;
  double price;

  public Book(String title, String author, String publicationName, double price) {
    this.author = author;
    this.price = price;
    this.publisher = publicationName;
    this.title = title;
  }

  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
  }
}