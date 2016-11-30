public class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber) {
	super(author, title, ISBN, callNumber);
    }

    public String currentHolder() {
	return currentHolder;
    }

    public String dueDate() {
	return dueDate;
    }

    public void setCurrentHolder(String newHolder) {
	currentHolder = newHolder;
    }

    public void setDueDate(String newDate) {
	dueDate = newDate;
    }

    public void checkout(String patron, String due) {
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned() {
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus() {
	if (currentHolder == null && dueDate == null) {
	    return "book available on shelves";
	}
	else {
	    return currentHolder + ", " + dueDate;
	}
    }

    public String toString() {
	if (currentHolder == null && dueDate == null) {
	    return super.toString();
	}
	else {
	    return super.toString() + ", " + currentHolder + ", " + dueDate;
	}
    }
}
