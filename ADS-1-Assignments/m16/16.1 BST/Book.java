abstract class BookBase {
	abstract String getName();
}

class Book extends BookBase implements Comparable<Book> {
	private String name;
	private String author;
	private float price;
	Book(final String n, final String a,
		final float p) {
		name = n;
		author = a;
		price = p;
	}
	String getName() {
		return name;
	}
	String getAuthor() {
		return author;
	}
	float getPrice() {
		return price;
	}
	public int compareTo(Book b) {
		return -1;
	}
}
