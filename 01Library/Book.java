public class Book {
    private String author;
    private String title;
    private String ISBN;

    public Book() {
    }

    public Book(String author, String title, String ISBN) {
	author = author;
	title = title;
	ISBN = ISBN;
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
	author = author;
    }

    public void setTitle(String title) {
	title = title;
    }

    public void setISBN(String ISBN) {
	ISBN = ISBN;
    }

    public String toString() {
	return title + ", " + author + ", " + ISBN;
    }

}
