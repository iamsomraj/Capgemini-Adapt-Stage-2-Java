import java.util.*;

class Utility {
   public static int fahrenheitToCelcius(double farhenheit) {
      int celcius = (int) Math.round((farhenheit - 32) * 5 / 9);
      return celcius;
   }

   public static String getLevel(int[] arr) {
      int sum = 0;
      for (int i : arr) {
         sum += i;
      }
      if (sum >= 100) {
         return "HIGH";
      }
      if (sum >= 70) {
         return "MEDIUM";
      }
      return "LOW";
   }
}

class Source {

   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int option = sc.nextInt();
      if (option == 1) {
         System.out.println(Utility.fahrenheitToCelcius(sc.nextDouble()));
      } else if (option == 2) {
         int n = sc.nextInt();
         int[] arr = new int[n];
         for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
         }
         System.out.println(Utility.getLevel(arr));
      } else {
         System.out.println("Invalid Option");
      }
   }
}