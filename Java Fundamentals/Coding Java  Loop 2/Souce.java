
// give this repo a star if you find this useful :)
import java.util.Scanner;

/**
 * Main class
 */
class Source {

   public static boolean isPrime(int number) {
      for (int i = 2; i <= Math.round((float) number/2); i++) {
         if (number % i == 0) {
            return false;
         }
      }
      return true;
   }

   /**
    * Main method
    * 
    * @param args
    */
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int a = scanner.nextInt();
      if (a < 3) {
         System.out.println("INVALID_INPUT");
         return;
      }
      int b = scanner.nextInt();
      if (b > 1000) {
         System.out.println("INVALID_INPUT");
         return;
      }
      if (a > b) {
         System.out.println("INVALID_INPUT");
         return;
      }
      int sum = 0;
      for (int i = a; i <= b; i++) {
         if (isPrime(i)) {
            sum += i;
         }
      }

      System.out.println(sum);

   }
}
