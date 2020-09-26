import java.util.*;

class Source {

   private static TreeMap<String, String> tree;

   public Source() {
      tree = new TreeMap<String, String>();
   }

   public String getNumber(String name) {
      String s1 = name;
      if (tree.containsKey(s1)) {
         if (tree.get(s1) != null) {
            return tree.get(s1);
         }
      }
      return null;
   }

   public boolean getName(String number) {
      Set<String> keys = tree.keySet();
      for (String key : keys) {
         if (tree.get(key).equals(number)) {
            return true;
         }
      }
      return false;
   }

   public String putNumber(String name, String number) {

      try {
         if (name != null && number != null) {
            tree.put(name, number);
            return "True";
         } else {
            throw new IllegalArgumentException("Name or Number: NULL Exception");
         }
      } catch (IllegalArgumentException e) {
         return "Name or Number: NULL Exception";
      } catch (NullPointerException n) {
      }
      return null;
   }

   public TreeMap<String, String> print() {
      return tree;
   }

   public static void main(String[] args) {

      Source directory = new Source();
      String put1 = directory.putNumber("A1", "1111");
      String get1 = directory.getNumber("A1");
      String put2 = directory.putNumber("A2", "2222");
      String get2 = directory.getNumber("A2");
      String put3 = directory.putNumber("A3", "3333");
      String get3 = directory.getNumber("A3");
      TreeMap<String, String> dataTree = directory.print();
      System.out.println(put1);
      System.out.println(put2);
      System.out.println(put3);
      System.out.println(dataTree);
      System.out.println(get1);
      System.out.println(get2);
      System.out.println(get3);
   }
}