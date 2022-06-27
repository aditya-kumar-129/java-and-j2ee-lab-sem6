package BookList;

public class Main {
  public static void main(String[] args) {
    BookList obj = new BookList();
    System.out.println("BookList are:- ");
    obj.display();
    obj.findAuthorBook();
    obj.findBookByPublisherName();
    obj.findBookByTitle();
    obj.sortBook();
    obj.SortBookByPrice();
    obj.updatePublisherName();
    obj.display();
  }
}