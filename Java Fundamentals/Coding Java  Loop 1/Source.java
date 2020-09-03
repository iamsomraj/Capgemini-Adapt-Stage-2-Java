// star this repo if you find this useful :)
import java.util.*;

class Source {

   public static int toAnyBase(int dec, int base) {
      if (dec == 0) {
         return 0;
      } else {
         return dec % base + 10 * (toAnyBase(dec / base, base));
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int decimalInput = scanner.nextInt();
      if (decimalInput < 1 || decimalInput > 999) {
         System.out.println("INVALID_INPUT");
         return;
      } else {
         // Below is the one line method
         // System.out.println(Integer.toBinaryString(decimalInput));


         // passing base as 2 for binary
         // it works with any base
         System.out.println(toAnyBase(decimalInput, 2));
      }
   }
}