public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "10.Kinoshita.Naotaka"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	for (int i = 0 ; i < data.length ; i ++) {
	    int temp = data[i];
	    int place = i;
	    for (int e = i + 1 ; e < data.length ; e ++) {
		if (data[e] < temp) {
		    temp = data[e];
		    place = e;
		}
	    }
	    data[place] = data[i];
	    data[i] = temp;
	}
    }

    public static void insertionSort(int[] data) {
	for (int i = 1 ; i < data.length ; i ++) {
	    int t = i;
	    for (int e = i; e > 0 ; e --) {
		if (data[i] < data[e]) {
		    t --;
		}
	    }
	    int temp = data[i];
	    for (int place = i; place > t + 1; place --) {
		data[place] = data[place - 1];
	    }
	    data[t] = temp;
	}
    }

    public static void bubbleSort(int[] data) {
	
    }

    public static void main(String[] args) {
	int[] a = {6,3,1,7,5,9,4,0,2};
	insertionSort(a);
	for (int i = 0; i < a.length; i ++) {
	    System.out.print(a[i] + ",");
	}
	System.out.println();
	int[] b = {};
	insertionSort(b);
	for (int i = 0 ; i < b.length; i ++){
	    System.out.print(b[i] + ",");
	}
	System.out.println();
	int[] c = {10};
	insertionSort(c);
	for (int i = 0; i < c.length; i++) {
	    System.out.print(c[i] + ",");
	}
	System.out.println();
	int[] d = {400,303,1500,1759,1618,13,11,1436,2168,1172,5280,2016,38387};
	insertionSort(d);
	for (int i = 0 ; i < d.length; i ++) {
	    System.out.print(d[i] + ",");
	}
	System.out.println();
    }
}

