// star this repo if you find this useful :)

import java.util.*;

class desComparator implements Comparator<Integer> {
   @Override
   public int compare(Integer o1, Integer o2) {
      return o2.intValue() - o1.intValue();
   }
}

/**
 * Main class
 */
public class Source {
   /**
    * Main method
    * 
    * @param args
    */
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int number = scanner.nextInt();
      if (number < 1 || number > 20) {
         System.out.println("INVALID_INPUT");
      } else {

         ArrayList<Integer> arrayList = new ArrayList<Integer>();
         for (int i = 0; i < number; i++) {
            arrayList.add(scanner.nextInt());
         }
         if (number % 2 == 0) {
            // if even, then ascending 1,2,3,4
            Collections.sort(arrayList);
         } else {
            // if odd, then descending 4,3,2,1
            Collections.sort(arrayList, new desComparator());

         }
         for (int i = 0; i < number; i++) {
            System.out.printf("%d ", arrayList.get(i));
         }
      }
   }
}
