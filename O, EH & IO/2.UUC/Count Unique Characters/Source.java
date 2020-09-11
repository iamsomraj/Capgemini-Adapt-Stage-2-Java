import java.util.Scanner;

public class Source {
   public static int getUniqueCharacterCount(String input) {
      input = input.replaceAll("\\s", "");
      input = input.toLowerCase();
      int count = 0;
      for (int i = 0; i < input.length(); i++) {
         boolean contains = false;
         for (int j = 0; j < input.length(); j++) {
            if (input.charAt(i) == input.charAt(j) && i != j) {
               contains = true;
               break;
            }
         }
         if (!contains) {
            count++;
         }
      }
      if (count > 0) {
         return count;
      }
      return -1;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      int result = getUniqueCharacterCount(input);
      if (result == -1) {
         System.out.println("No unique character/s");
      } else {
         System.out.println(result + " unique character/s");
      }
   }
}