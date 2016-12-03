import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String> {
    private SuperArray ary;
    private int i;

    public SuperArrayIterator(SuperArray a) {
	ary = a;
	i = 0;
    }

    public boolean hasNext() {
	return i < ary.size() - 1;
    }

    public String next() {
	i ++;
	return ary.get(i);
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }

}
