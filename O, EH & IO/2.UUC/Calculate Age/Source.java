import java.time.LocalDate;
import java.time.Period;
import java.util.*;

class AgeCalculator {
   public int[] calculateAge(String str) {
      int arr[] = new int[2];
      String[] date = str.split("/");
      int month = Integer.parseInt(date[1]);
      int year = Integer.parseInt(date[2]);
      if ((year == 2019 && month <= 3) || (year <= 2018)) {
         LocalDate birthDate = LocalDate.of(year, month, 1);
         LocalDate current = LocalDate.of(2019, 4, 1);
         arr[0] = Period.between(birthDate, current).getYears();
         arr[1] = Period.between(birthDate, current).getMonths();
         return arr;
      }
      return null;
   }
}

class Source {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String date = sc.nextLine();
      AgeCalculator ac = new AgeCalculator();
      int arr[] = ac.calculateAge(date);

      if (arr != null) {
         if (arr[0] != 0 && arr[1] != 0) {
            System.out.println("Years : " + arr[0] + ", Months : " + arr[1]);
            return;
         }

         if (arr[0] == 0 && arr[1] != 0) {
            System.out.println("Months : " + arr[1]);
            return;
         }

         if (arr[0] != 0 && arr[1] == 0) {
            System.out.println("Years : " + arr[0]);
            return;
         }
      } else {
         System.out.println("Invalid date of birth");
      }
   }
}
