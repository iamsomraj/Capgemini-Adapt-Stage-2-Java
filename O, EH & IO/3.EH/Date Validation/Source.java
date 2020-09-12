import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Utility {
   public static int checkDate(String dateValue) {
      int returnVal = -1;
      String[] permissFormats = new String[] { "dd/MM/yyyy", "dd-MM-yyyy", "dd.MM.yyyy" };
      for (int i = 0; i < permissFormats.length; i++) {
         try {
            SimpleDateFormat sdfObj = new SimpleDateFormat(permissFormats[i]);
            sdfObj.setLenient(false);
            sdfObj.parse(dateValue);
            returnVal = 1;
            break;
         } catch (ParseException e) {
         }
      }
      return returnVal;
   }
}

public class Source {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String date = scanner.next();
      int n = Utility.checkDate(date);
      if (n == 1) {
         System.out.println("Valid");
      } else {
         System.out.println("Invalid");
      }
   }
}
