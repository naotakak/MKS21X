import java.lang.Integer;

public class Barcode implements Comparable<Barcode>{
   private String _zip;
   private int _checkDigit;

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

  private static int checkSum(zip){
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
	  String code;
	  switch (e) {
	  case 0: code = "||:::";
	      break;
	  case 1: code = ":::||";
	      break;
	  case 2: code = "::|:|";
              break;
          case 3: code = "::||:";
              break;
	  case 4: code = ":|::|";
	      break;
	  case 5: code = ":|:|:";
	      break;
	  case 6: code = ":||::";
	      break;
	  case 7: code = "|:::|";
	      break;
	  case 8: code = "|::|:";
	      break;
	  case 9: code = "|:|::";
	      break;
	  default : code = "";
	      break;
	  }
	  s += code;
      }
      s += "|";
      return s;
  }

  public static String toCode(String zip) {
      String s = "|";
      String zip1 = zip + checkSum(zip);
      for (int i = 0; i < zip1.length() ; i ++) {
	  char e = zip1.charAt(i);
	  String code;
	  switch (e) {
	  case 0: code = "||:::";
	      break;
	  case 1: code = ":::||";
	      break;
	  case 2: code = "::|:|";
              break;
          case 3: code = "::||:";
              break;
	  case 4: code = ":|::|";
	      break;
	  case 5: code = ":|:|:";
	      break;
	  case 6: code = ":||::";
	      break;
	  case 7: code = "|:::|";
	      break;
	  case 8: code = "|::|:";
	      break;
	  case 9: code = "|:|::";
	      break;
	  default : code = "";
	      break;
	  }
	  s += code;
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
      String s = ""
      for (int i = 0 ; i < 6 ; i ++) {
	  if (code.substring(i, i + 6).equals("||:::") {
		  s += "0";
	      }
	   
      
// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
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
