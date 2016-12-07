import java.lang.Integer;

public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length() > 5) {
	  throw new RuntimeException();
      }
      try {
	  Integer.parseInt(zip);
      }catch (NumberFormatException e) {
	  throw new RuntimeException();
      }
      _zip = zip;
      _checkDigit = checkSum(); 
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int tempZ = Integer.parseInt(_zip);
      int sum = 0;
      int i = 1;
      while (i < 5) {
	  sum += (tempZ % 10 ^ i);
	  i ++;
      }
      return sum % 10;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String zip1 = _zip + _checkDigit;
      String s = zip1 + " |"
      for (int i = 0; i < zip1.length() ; i ++) {
	  char e = zip1.charAt(i);
	  String 
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    
}
