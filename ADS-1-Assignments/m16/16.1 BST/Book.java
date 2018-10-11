class Book implements Comparable<Book> {
	private String name;
	private String author;
	private double price;
	Book(final String n, final String a,
		final double p) {
		name = n;
		author = a;
		price = p;
	}
	String getName() {
		return this.name;
	}
	public int compareTo(final Book b) {
		return this.getName().compareTo(b.getName());
	}
}
