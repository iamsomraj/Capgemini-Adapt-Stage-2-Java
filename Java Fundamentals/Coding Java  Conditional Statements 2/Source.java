import java.util.*;

class Source {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int arr[] = new int[3];
      for (int i = 0; i < 3; i++) {
         arr[i] = scanner.nextInt();
         if (i != 0) {
            if (arr[i] > arr[i - 1]) {
               System.out.println("INVALID_INPUT");
               return;
            }
         }
      }
      int firstSquare = arr[0] * arr[0];
      int secondSquare = arr[1] * arr[1];
      int thirdSquare = arr[2] * arr[2];
      if (firstSquare == (secondSquare + thirdSquare)) {
         System.out.println("RIGHT ANGLE");
      } else {
         System.out.println("NOT RIGHT ANGLE");
      }
   }
}