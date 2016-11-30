public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String callNumber) {
	super(author, title, ISBN);
	this.callNumber = callNumber;
    }

    public String callNumber() {
	return callNumber;
    }

    public void setCallNumber(String callNumber) {
	this.callNumber = callNumber;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public int compareTo(LibraryBook b) {
	if (callNumber != null) {
	    if (callNumber().compareTo(b.callNumber()) < 0) {
		return -1;
	    }
	    if (callNumber().compareTo(b.callNumber()) > 0) {
		return 1;
	    }
	    else {
		return 0;
	    }
	}
	else {
	    return 0;
	}
    }

    public String toString() {
	return super.toString() + ", " + circulationStatus() + ", " + callNumber();
    }
}
