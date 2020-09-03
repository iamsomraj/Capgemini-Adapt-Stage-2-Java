// star this repo if you find this useful

import java.util.*;

class stringSorter implements Comparator<String> {
   @Override
   public int compare(String o1, String o2) {
      if (o1.length() < o2.length()) {
         return -1;
      }
      if (o1.length() > o2.length()) {
         return 1;
      }
      return o1.compareTo(o2);
   }
}

public class Source {

   public static List<String> sort(String input) {
      if (input == null) {
         return new ArrayList<String>();
      } else {
         String words[] = input.split(" ");
         ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(words));
         Collections.sort(arrayList, new stringSorter());
         return arrayList;
      }

   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(sort(scanner.nextLine()));

   }
}