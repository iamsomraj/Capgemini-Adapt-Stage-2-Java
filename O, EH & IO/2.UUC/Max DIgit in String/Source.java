import java.util.Scanner;

class Source {
   public static int getMaxDigit(String str) {
      if (str == null) {
         return -1;
      }
      if (str.isEmpty()) {
         return -1;
      }
      str = str.replaceAll("\\D", "");
      if (str.isEmpty()) {
         return -1;
      }
      String arr[] = str.split("");
      int max = Integer.MIN_VALUE;
      for (String s : arr) {
         int number = Integer.parseInt(s);
         if (max < number) {
            max = number;
         }
      }
      if (max == Integer.MIN_VALUE) {
         return -1;
      } else {
         return max;
      }
   }

   public static void main(String[] args) {
      // Code here
      Scanner sc = new Scanner(System.in);
      int n = getMaxDigit(sc.nextLine());
      if (n == 0 || n == -1) {
         System.out.println("No digits in string");
      } else {
         System.out.println("Max digit : " + n);
      }
   }
}