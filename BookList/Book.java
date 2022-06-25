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
    return "Name of the auther is :- " + author + " Title of the Book is :- " + title + " Publisher Name is :-  " + publisher + " price of the book is :-  " + price;
  }
}