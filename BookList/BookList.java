package BookList;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class BookList {
  Scanner sc = new Scanner(System.in);
  ArrayList<Book> bookList = new ArrayList<>();

  public BookList() {
    while (true) {
      System.out.println("Press 1 to enter the new record else enter 0");
      int choice = Integer.parseInt(sc.nextLine());
      if (choice == 1) {
        System.out.println("Enter the Author Name of the Book :-");
        String author = sc.nextLine();
        System.out.println("Enter the Title Name of the Book :-");
        String title = sc.nextLine();
        System.out.println("Enter the Publisher Name of the Book :-");
        String publisherName = sc.nextLine();
        System.out.println("Enter the price of the Book :-");
        double price = Double.parseDouble(sc.nextLine());
        Book newBookData = new Book(title, author, publisherName, price);
        bookList.add(newBookData);
      } else
        break;
    }
  }

  void sortBook() {
    ArrayList<Book> copyOfBookList = new ArrayList<>(bookList);
    Collections.sort(copyOfBookList, new Comparator<Book>() {
      public int compare(Book b1, Book b2) {
        if (b1.price > b2.price)
          return 1;
        if (b1.price == b2.price)
          return 0;
        else
          return -1;
      }
    });
    System.out.println("Sorted BookList is :- ");
    for (Book itr : copyOfBookList)
      System.out.println(itr);
  }

  void findAuthorBook() {
    System.out.println("Enter Author Name to search in the bookList:- ");
    String AuthorName = sc.nextLine();
    for (Book itr : bookList)
      if (itr.author.equalsIgnoreCase(AuthorName))
        System.out.println(itr);
  }

  void findBookByPublisherName() {
    System.out.println("Enter Publisher Name to search in the bookList:- ");
    String PublisherName = sc.nextLine();
    for (Book itr : bookList)
      if (itr.publisher.equalsIgnoreCase(PublisherName))
        System.out.println(itr);
  }

  void findBookByTitle() {
    System.out.println("Enter title of the book to search in the bookList:- ");
    String title = sc.nextLine();
    int entered_titleLength = title.length();
    for (Book itr : bookList) {
      int currentBook_titleLength = itr.title.length();
      if (itr.title.substring(currentBook_titleLength - entered_titleLength, currentBook_titleLength).equalsIgnoreCase(title))
        System.out.println(itr);
    }
  }

  void SortBookByPrice() {
    ArrayList<Book> groupBookByPrice = new ArrayList<>();
    System.out.println("Enter the price above which you want all the suggestions:- ");
    int query_Price = Integer.parseInt(sc.nextLine());
    for (Book itr : bookList)
      if (itr.price > query_Price)
        groupBookByPrice.add(itr);
    System.out.println("Grouped books are :- ");
    for (Book itr : groupBookByPrice)
      System.out.println(itr);
  }

  void updatePublisherName() {
    System.out.println("Enter title of the book whose publisher Name has to be updated :- ");
    String query_title = sc.nextLine();
    System.out.println("Enter new publisher Name:- ");
    String updated_publisherName = sc.nextLine();
    for (Book itr : bookList)
      if (itr.title.equalsIgnoreCase(query_title))
        itr.publisher = updated_publisherName;
  }

  public void display() {
    System.out.println("All books ");
    for (Book itr : bookList)
      System.out.println(itr);
  }
}