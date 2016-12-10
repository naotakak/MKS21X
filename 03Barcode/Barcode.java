import java.lang.Integer;
import java.util.ArrayList;
public class Barcode extends ArrayList<String> implements Comparable<Barcode>{
   private String _zip;
   private int _checkDigit;
   private String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
   static private ArrayList<String> c;
   /*
   private void thing() {
       for (int i = 0 ; i < codes.length() ; i ++) {
	   c.add(codes[i]);
       }
   }
   */

   public Barcode(String zip) {
       if (zip.length() != 5) {
	   throw new IllegalArgumentException("Incorrect length");
       }
       try {
	   Integer.parseInt(zip);
       }catch (NumberFormatException e) {
	   throw new IllegalArgumentException("bad format");
       }
       _zip = zip;
       _checkDigit = checkSum(_zip); 
   }

   public String zip() {
       return _zip;
   }

   public int checkDigit() {
       return _checkDigit;
   }

   private static int checkSum(String zip){
       int tempZ = Integer.parseInt(zip);
       int sum = 0;
       int i = 1;
       while (i < 5) {
	   sum += (tempZ % 10 ^ i);
	   i ++;
       }
       return sum % 10;
   }
   
   public String toString(){
       String zip1 = _zip + _checkDigit;
       String s = zip1 + " |";
       for (int i = 0; i < zip1.length() ; i ++) {
	   char e = zip1.charAt(i);
	   s += codes[Integer.parseInt("" + e)];
       }
       s += "|";
       return s;
   }
   
   public static String toCode(String zip) {
       String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
       String s = "|";
       String zip1 = zip + checkSum(zip);
       for (int i = 0; i < zip1.length() ; i ++) {
	   char e = zip1.charAt(i);
	   s += codes[Integer.parseInt("" + e)];
       }
       s += "|";
       return s;
   }
   
   public static String toZip(String code) {
       if (code.length() != 32) {
	   throw new IllegalArgumentException("Invalid length");
       }
       if (code.charAt(0) != '|' && code.charAt(31) != '|') {
	   throw new IllegalArgumentException("Invalid guardrails");
       }
       for (int i = 0 ; i < code.length() ; i ++) {
	   if (code.charAt(i) != ':' || code.charAt(i) != '|') {
	       throw new IllegalArgumentException("non-barcode character");
	   }
       }
       String s = "";
       for (int i = 0 ; i < 6 ; i ++) {
	   int sizeBefore = s.length();
	   for (int e = 0; e < c.size() ; e ++) {
	       if (code.substring(i, i + 6).equals(c.get(e))) {
		   s += e;
	       }
	   }		       
	   if (sizeBefore == s.length()) {
	       throw new IllegalArgumentException("encoded ints are invalid");
	   }
       }
       if (! checkSum("" + (Integer.parseInt(s) - (Integer.parseInt(s) % 10)).equals("" + (Integer.parseInt(s) % 10)))) {
	   throw new IllegalArgumentException("invalid checksum");
       }
       return s;
   }	   
      
   public int compareTo(Barcode other) {
       int z = Integer.parseInt(_zip + _checkDigit);
       int o = Integer.parseInt(other.zip() + other.checkDigit());
       if (z < o) {
	   return -1;
       }
       if (z > o) {
	   return 1;
       }
       else {
	   return 0;
       }
   }
}
