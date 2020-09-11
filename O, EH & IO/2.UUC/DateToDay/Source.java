import java.util.Scanner;

//import statements here 

public class Source {
   // this is a formula
   public static int dayOfWeek(int d, int m, int y) {
      int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
      if (m < 3) {
         y = y - 1;
      }
      return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(getDayOfDate(scanner.nextLine()));
   }

   public static String getDayOfDate(String date) {
      String input[] = date.split("/");
      int d = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);
      int y = Integer.parseInt(input[2]);
      int index = dayOfWeek(d, m, y);
      String days[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
      return days[index];
   }
}
