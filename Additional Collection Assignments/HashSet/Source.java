import java.util.*;

public class Source {
   public static Set<Integer> union(Set<Integer> setA, Set<Integer> setB) {
      Set<Integer> result = new HashSet<Integer>(setA);
      result.addAll(setB);
      return result;
   }

   public static Set<Integer> intersect(Set<Integer> setA, Set<Integer> setB) {
      Set<Integer> result = new HashSet<Integer>();
      for (Integer x : setA)
         if (setB.contains(x))
            result.add(x);
      return result;
   }

   public static Set<Integer> subtract(Set<Integer> setA, Set<Integer> setB) {
      Set<Integer> result = new HashSet<Integer>(setA);
      result.removeAll(setB);
      return result;
   }
}