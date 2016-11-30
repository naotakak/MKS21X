public class Book {
    private String author;
    private String title;
    private String ISBN;

    public Book() {
    }

    public Book(String author, String title, String ISBN) {
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }

    public String author() {
	return author;
    }

    public String title() {
	return title;
    }

    public String ISBN() {
	return ISBN;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public void setISBN(String ISBN) {
	this.ISBN = ISBN;
    }

    public String toString() {
	return title + ", " + author + ", " + ISBN;
    }

}
