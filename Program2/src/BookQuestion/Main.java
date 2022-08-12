package BookQuestion;

public class Main {
	public static void main(String[] args) {
		BookList bookListObject = new BookList();
		bookListObject.sortBookByPrice();
		bookListObject.findBookByAutherName();
		bookListObject.findBookByPublisherName();
		bookListObject.collectBookByPrice();
		bookListObject.updatePublisherDetail();
		bookListObject.findBookByTitle();
	}
}