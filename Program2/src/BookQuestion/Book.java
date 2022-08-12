package BookQuestion;

public class Book {
	String title,author_Name,publisher_Name;
	double price;
	
	
	public Book(String title, String author_Name, String publisher_Name, double price) {
		this.title = title;
		this.author_Name = author_Name;
		this.publisher_Name = publisher_Name;
		this.price = price;
	}

	public String toString() {
		return "Book [Title=" + title + ", Author_Name=" + author_Name + ", Publisher_Name=" + publisher_Name + ", price=" + price + "]";
	}
	
}