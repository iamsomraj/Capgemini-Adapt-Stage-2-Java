
// I am assuming the marks as integer
import java.util.Scanner;

class App {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int marks1 = scanner.nextInt();
      int marks2 = scanner.nextInt();
      int marks3 = scanner.nextInt();
      int average = (int) (marks1 + marks2 + marks3) / 3;
      if (average > 85) {
         System.out.println("First Class Category");
      } else if (average > 70) {
         System.out.println("Pass");
      } else {
         System.out.println("Failed");
      }
   }
}