
import java.util.*;

public class Source {

   public ArrayList<String> copy(ArrayList<String> list) {
      return list;
   }

   public String PrintIndex(ArrayList<String> list) {
      return list.get(0);
   }

   public ArrayList<String> addAfter(ArrayList<String> list, String m, String n) {
      list.add(list.indexOf(m) + 1, n);
      return list;
   }

}