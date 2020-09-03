// if you find this useful, star this repo :)
import java.util.*;

class Source {

   public static String[] getToys(String arr[]) {
      ArrayList<String> input = new ArrayList<String>(Arrays.asList(arr));
      Collections.sort(input);
      String[] result = new String[input.size()];
      for (int i = 0; i < result.length; i++) {
         result[i] = input.get(i);
      }
      return result;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String inputArray[] = new String[5];
      for (int i = 0; i < inputArray.length; i++) {
         inputArray[i] = scanner.nextLine().trim();
      }
      String result[] = getToys(inputArray);
      for (String str : result) {
         System.out.println(str);
      }
   }
}