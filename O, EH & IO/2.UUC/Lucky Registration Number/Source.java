import java.util.*;
import java.util.regex.*;

/**
 * Source
 */
public class Source {

   public static int checkRegistrationNumber(String regNo) {
      if ( regNo == null)
         return -1;

      if ( regNo.isEmpty() )
         return -1;
      
      String regex = "(KA|DL)(01|02|03|04|05|06|07|08|09|10)[A-Z]{1,2}[1-9]{1}[0-9]{3}$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(regNo);
      if (matcher.matches()) {
         int number = Integer.parseInt(regNo.substring(regNo.length() - 4, regNo.length()));
         int sum = 0;
         while (number > 0 || sum > 9) {
            if (number == 0) {
               number = sum;
               sum = 0;
            }
            int rem = number % 10;
            sum = sum + rem;
            number /= 10;
         }
         if (sum == 6) {
            return 1;
         }
         return 0;
      }
      return -1;

   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String reg = scanner.nextLine();
      int r = checkRegistrationNumber(reg);
      if (r == 1) {
         System.out.println("Lucky registration number");
      } else if (r == 0) {
         System.out.println("Valid registration number");
      } else {
         System.out.println("Invalid registration number");
      }

   }
}