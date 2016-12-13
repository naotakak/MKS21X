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
	    for (int e = i + 1 ; e < data.length ; e ++) {
		if (data[e] > temp) {
		    temp = data[e];
		}
		data[e] = data[i];
		data[i] = temp;
	    }
	}
    }
    
    
}

