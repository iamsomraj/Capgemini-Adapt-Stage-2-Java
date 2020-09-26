import java.util.*;

public class Source {
   public void addItem(ArrayList<String> list, String item) {
      list.add(item);
   }

   public String modifyItem(ArrayList<String> list, int index, String item) {
      list.set(index, item);
      return "Item of index " + index + " has been modified.";
   }

   public String removeItem(ArrayList<String> list, int index) {
      list.remove(index);
      return "Item of index " + index + " has been removed.";
   }

   public String searchItem(ArrayList<String> list, String searchItem) {
      return list.contains(searchItem) ? searchItem : "no such item";
   }

   public int getSize(ArrayList<String> list) {
      return list.size();
   }

}
