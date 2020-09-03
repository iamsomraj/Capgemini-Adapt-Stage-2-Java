import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Source {
   public List<Integer> getSumOfListElements(List<Integer> first, List<Integer> second) {
      ArrayList<Integer> arr1 = new ArrayList<Integer>();
      if (first == null && second == null ){
         return arr1;
      }
      if (first == null) {
         return second;
      }
      if (second == null) {
         return first;
      }
      int limit = first.size() < second.size() ? first.size() : second.size();
      for (int i = 0; i < limit; i++) {
         arr1.add(first.get(i) + second.get(i));
      }
      if (limit == first.size()) {
         for (int i = limit; i < second.size(); i++) {
            arr1.add(second.get(i));
         }
      } else {
         for (int i = limit; i < first.size(); i++) {
            arr1.add(first.get(i));
         }
      }
      return arr1;
   }

   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      String s1 = scanner.nextLine();
      String s2 = scanner.nextLine();
      String input1[] = s1.split(", ");
      String input2[] = s2.split(", ");
      ArrayList<Integer> arr1 = new ArrayList<Integer>();
      ArrayList<Integer> arr2 = new ArrayList<Integer>();
      for (String str : input1) {
         arr1.add(Integer.parseInt(str));
      }
      for (String str : input2) {
         arr2.add(Integer.parseInt(str));
      }
      List<Integer> result = new Source().getSumOfListElements(arr1, arr2);
      System.out.println(result);

   }
}
