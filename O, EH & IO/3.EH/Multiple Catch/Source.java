import java.util.*;

class Sequence {
   public static int sequences(String str) throws NumberFormatException {
      String s[] = str.split(",");
      int arr[] = new int[s.length];
      int copy[] = new int[s.length];
      for (int i = 0; i < s.length; i++) {
         arr[i] = Integer.parseInt(s[i]);
         copy[i] = Integer.parseInt(s[i]);
      }
      int iteration = 1;
      while (iteration != arr.length) {
         for (int i = iteration; i < arr.length; i++) {
            arr[i] = copy[i] - copy[i - 1];
         }
         for (int i = iteration; i < arr.length; i++) {
            copy[i] = arr[i];
         }
         iteration++;
      }
      return arr[arr.length - 1];
   }
}

class Source {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str;
      try {
         str = sc.next();
         int result = Sequence.sequences(str);
         System.out.println(result);
      } catch (ArrayIndexOutOfBoundsException e) {
      } catch (NumberFormatException e) {
      }

   }
}