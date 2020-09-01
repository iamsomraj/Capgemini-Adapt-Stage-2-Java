import java.util.*;

public class Source {

   public static void main(String[] args) throws IllegalArgumentException {
      try {
         Scanner scanner = new Scanner(System.in);
         String firstList = scanner.nextLine();
         String secondList = scanner.nextLine();
         if (firstList.isEmpty() || secondList.isEmpty()) {
            throw new IllegalArgumentException();
         }
         String first[] = firstList.split(" ");
         String second[] = secondList.split(" ");
         if (first.length == 5 && second.length == 5) {
            ArrayList<Integer> arr1 = new ArrayList<Integer>();
            ArrayList<Integer> arr2 = new ArrayList<Integer>();
            for (String str : first) {
               arr1.add(Integer.parseInt(str));
            }
            for (String str : second) {
               arr2.add(Integer.parseInt(str));
            }
            System.out.println(mergeAndSort(arr1, arr2));
         } else {
            throw new IllegalArgumentException();
         }
      } catch (Exception e) {

      }

   }

   public static List<Integer> mergeAndSort(List<Integer> al1, List<Integer> al2) {
      ArrayList<Integer> arr1 = new ArrayList<Integer>();
      arr1.addAll(al1);
      arr1.addAll(al2);
      Collections.sort(arr1);
      ArrayList<Integer> result = new ArrayList<Integer>();
      result.add(arr1.get(2));
      result.add(arr1.get(6));
      result.add(arr1.get(8));
      return result;
   }

}
