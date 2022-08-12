package BookQuestion;

import java.util.*;

public class BookList {
	Scanner sc = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<Book> ();
	
	public BookList(){
		while(true) {
			System.out.println("Enter 1 to add a new record or 0 to exit");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice ==1) {
				System.out.println("Enter the title of the book:- ");
				String title = sc.nextLine();
				System.out.println("Enter the Author Name of the book:- ");
				String author_Name = sc.nextLine();
				System.out.println("Enter the Publisher Name of the book:- ");
				String publisher_Name = sc.nextLine();
				System.out.println("Enter the price of the book:- ");
				int price = Integer.parseInt(sc.nextLine());
				Book newBookData = new Book(title,author_Name,publisher_Name,price);
				bookList.add(newBookData);
			}
			else {
				System.out.println("Books present in the BookList are :- ");
				display();
				break;
			}
		}
	}
	
	// Sorting Book by price by first copying the booklist to other variable
	void sortBookByPrice() {
		ArrayList<Book> duplicateBookList = new ArrayList<>(bookList);
		Collections.sort(duplicateBookList , new Comparator<Book> () {
			public int compare(Book b1, Book b2) {
				if(b1.price > b2.price)
					return 1;
				else if(b1.price < b2.price)
					return -1;
				else
					return 0;
			}
		});
		System.out.println("Sorted BookList is :- ");
		for(Book itr : duplicateBookList)
			System.out.println(itr);
	}
	
	void findBookByAutherName() {
		System.out.println("Enter the Auther Name:- ");
		String query_auther_name = sc.nextLine();
		System.out.println("Book details having Auther Name:- " + query_auther_name + " are :- ");
		for(Book itr : bookList)
			if(itr.author_Name.equalsIgnoreCase(query_auther_name))
				System.out.println(itr);
	}
	
	void findBookByPublisherName() {
		System.out.println("Enter the Publisher Name:- ");
		String query_publisher_name = sc.nextLine();
		System.out.println("Book details having Publisher Name:- " + query_publisher_name + " are :- ");
		for(Book itr : bookList)
			if(itr.publisher_Name.equalsIgnoreCase(query_publisher_name))
				System.out.println(itr);
	}
	
	void collectBookByPrice() {
		System.out.println("Enter the price of the book :- ");
		ArrayList<Book> collectBookList = new ArrayList <>();
		double bookPrice = Double.parseDouble(sc.nextLine());
		for(Book itr : bookList)
			if(itr.price > bookPrice)
				collectBookList.add(itr);
		System.out.println("Books having price graeter than " + bookPrice + " are:- ");
		for(Book itr :collectBookList)
			System.out.println(itr);
	}
	
	void updatePublisherDetail() {
		System.out.println("Enter the title of the book whose publisher name you want to change:- ");
		String query_title = sc.nextLine();
		System.out.println("Enter the updated publisher name:- ");
		String upadted_publisher_name = sc.nextLine();
		for(Book itr : bookList)
			if(itr.title.equalsIgnoreCase(query_title))
				itr.publisher_Name = upadted_publisher_name;
		
		System.out.println("Updated bookList are:- ");
		display();
	}
	
	void findBookByTitle () {
		System.out.println("Enter the title of the book:- ");
		String query_title = sc.nextLine();
		System.out.println("Books having/conatining title :- " +query_title + " are:- ");
		for(Book itr : bookList)
			if(itr.title.contains(query_title))
				System.out.println(itr);
	}
	
	void display() {
		for(Book itr : bookList)
			System.out.println(itr);
	}
}