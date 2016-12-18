import java.util.*;

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
	    int temp = data[i];
	    int t = i;
	    while (t > 0 && temp < data[t-1]) {
		data[t] = data[t - 1]; 
		t --;
	    }
	    data[t] = temp;
	}
    }

    public static void bubbleSort(int[] data) {
	for (int e = 0; e < data.length; e ++) {
	    int place = data.length;
	    for (int i = 0; i < place - 1; i ++) {
		int temp;
		if (data[i] > data[i + 1]) {
		    temp = data[i+1];
		    data[i + 1] = data[i];
		    data[i] = temp;
		}
	    }
	    place --;
	}
    }

    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    
    public static String Test(String method, int[]initial){
	    String sorted;
	    long startTime = System.currentTimeMillis();
	    int[] copy = new int[initial.length];
	    System.arraycopy( initial, 0, copy, 0, initial.length );
	    Arrays.sort(copy);
	    Object[] Sorted = {copy};
	    int[] ary = new int[initial.length];
	    System.arraycopy( initial, 0, ary, 0, initial.length );
	    switch(method){
	    case "selectionSort":Sorts.selectionSort(ary);
		break;
	    case "insertionSort":Sorts.insertionSort(ary);
		break;
	    case "bubbleSort":Sorts.bubbleSort(ary);
		break;
	    default: return "INVALID. CURENTLY THERE ARE ONLY:\nselectionSort, insertionSort, bubbleSort \nPlease try again.";
	    }
	    Object[] Applied = {ary};
	    if (Arrays.deepEquals(Sorted, Applied)){
		sorted="Did sort";
	    }
	    else{
		sorted="Did not sort";
	    }
	    long endTime = System.currentTimeMillis();
	    long time=endTime-startTime;
	    return String.format("%s: %s and took time of %s ms", method, sorted, time);
    }
    
    public static void main(String[] a){
	System.out.println(Test(a[0],randomArray(10000,1000)));
	
    }
}

