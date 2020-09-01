// star this repo if you find this useful :)

import java.util.Scanner;

public class Source {
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      int arr[] = new int[3];
      for (int i = 0; i < 3; i++) {
         int number = scanner.nextInt();
         if (number < 0 || number > 100) {
            System.out.println("INVALIDMARKS");
            return;
         } else {
            arr[i] = number;
         }
      }

      int averageMarks = 0;
      for (int i : arr) {
         averageMarks = averageMarks + i;
      }
      averageMarks = (int) averageMarks / 3;

      if (averageMarks >= 70) {
         System.out.println("DISTINCTION");
      } else if (averageMarks >= 60) {
         System.out.println("FIRST");
      } else if (averageMarks >= 50) {
         System.out.println("SECOND");
      } else if (averageMarks >= 40) {
         System.out.println("THIRD");
      } else {
         System.out.println("FAIL");
      }
      
   }
}