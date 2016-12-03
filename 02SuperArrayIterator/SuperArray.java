import java.util.*;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
  
    public SuperArray() {
	data = new String[10];
	size = 0;
    }

    public SuperArray(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	data = new String[initialCapacity];
	size = 0;
    }

    public SuperArray(String[]ary){
	data = new String[ary.length];
	size = ary.length;
    }
    
    public void setSize(int s) {
	size = s;
    }

    public int size(){
	return size;
    }

    public String get(int index) {
	if (index < 0 || index >=size()) {
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public boolean add(String n){
	size ++;
	while (size() > data.length) {
	    grow();
	}
	data[size() - 1] = n;
	return true;
    }

    private void grow(){
	String[]temp = new String[size * 2 + 1];
	for (int i = 0 ; i < size - 1; i ++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public String toString(){
	String f = "[ ";
	for (int i = 0 ; i < size - 1 ; i ++) {
	    f += data[i] + ", ";
	}
	f += "" + data[size - 1] + "]";
	return f;
    }

    public String toStringDebug(){
	String f = "[ ";
	for (int i = 0 ; i < size + 1; i ++) {
	    f += data[i] + ", ";
	}
	for (int i = size ; i < data.length ; i ++) {
	    f += "_, ";
	}
	f += "]";
	return f;
    }

    public void clear() {
	size = 0;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public String set(int index, String element) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	String temp = data[index];
	data[index] = element;
	return temp;
    }

    public boolean add(int index, String element) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	while (data.length < index) {
	    grow();
	}
	for (int i = size ; i > index  - 1; i -= 1) {
	    while (i > data.length) {
		grow();
	    }
	    if (i + 1 < data.length) {
		data[i + 1] = data[i];
	    }
	}
	size += 1;
	data[index] = element;
	return true;
    }

    public String remove(int index) {
	if (index < 0 || index >=size()) {
	    throw new IndexOutOfBoundsException();
	}
	String temp = data[index];
	for (int i = index ; i < size ; i ++) {
	    data[i] = data[i + 1];
	}
	size -= 1;
	return temp;
    }

    public String[] toArray() {
        String[]temp = new String[size];
	for (int i = 0 ; i < size ; i ++) {
	    temp[i] = data[i];
	}
	return temp;
    }
    
    public void trimToSize() {
	String[]temp = new String[size];
	for (int i = 0 ; i < size ; i ++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public int indexOf(String i) {
	int s = -1;
	for (int index = 0 ; index < size ; index ++) {
	    if (i.equals(data[index])) {
		return index;
	    }
	}
	return s;
    }

    public int lastIndexOf(String i) {
	int s = -1;
	for (int index = size - 1 ; index >= 0 ; index -= 1) {
	    if (i.equals(data[index])) {
		return index;
	    }
	}
	return s;
    }


    public Iterator<String> iterator() {
	return new SuperArrayIterator(this);
    }
    
    public static void main(String[] args) {
	SuperArray data = new SuperArray();
	int i = 0;
	while(i < 26){
	    data.add(""+(char)('A'+i%26));
	    i++;
	}
	System.out.println(data);
	System.out.println("Standard loop:");

	for(int n = 0; n < data.size(); n++){
	    System.out.print(data.get(n)+" ");
	}
	System.out.println();
	System.out.println("for-each loop:");
	for(String s : data){
	    System.out.print(s+" ");
        }
    }
}
