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

}

