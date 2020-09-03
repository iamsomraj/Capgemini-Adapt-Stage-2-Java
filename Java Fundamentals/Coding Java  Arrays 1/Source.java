// star this repo if you find this useful :)
import java.util.*;

public class Source {
   public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      // input 1
      int number = scanner.nextInt();
      if (number < 1 || number > 20) {
         System.out.println("INVALID_INPUT");
      } else {
         // creating array
         int arr[] = new int[number];
         // input 2
         for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
         }
         // setting max to min
         int min = Integer.MAX_VALUE;
         // setting min to max
         int max = Integer.MIN_VALUE;
         for (int n : arr) {
            if (min > n) {
               min = n;
            }
            if (max < n) {
               max = n;
            }
         }
         System.out.println("MIN=" + min);
         System.out.println("MAX=" + max);
      }
   }
}