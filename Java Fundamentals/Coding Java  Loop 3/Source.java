
// star this repo if you find this useful :)
import java.util.*;

class Source {

   public static boolean isArmstrong(int decimal) {
      int numberOfDigits = Integer.toString(decimal).length();
      int sum = 0;
      int temp = decimal;
      while (temp != 0) {
         int rem = temp % 10;
         int powerValue = 1;
         for (int i = 0; i < numberOfDigits; i++) {
            powerValue = powerValue * rem;
         }
         sum = sum + powerValue;
         temp /= 10;
      }
      if (sum == decimal) {
         return true;
      } else {
         return false;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int number = scanner.nextInt();
      if (Integer.toString(number).length() != 3) {
         System.out.println("INVALID_INPUT");
         return;
      } else {
         if (isArmstrong(number)) {
            System.out.println("ARMSTRONG");
         } else {
            System.out.println("NOT ARMSTRONG");
         }
      }
   }

}