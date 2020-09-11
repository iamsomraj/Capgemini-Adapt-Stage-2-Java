import java.util.*;


class Source {
   public static int validateHexCode(String code) {
      if (code.startsWith("#")) {
         if (code.length() == 7) {
            for (int i = 1; i < code.length(); i++) {
               if ((code.charAt(i) >= 'A' && code.charAt(i) <= 'F')
                     || (code.charAt(i) >= '0' && code.charAt(i) <= '9')) {
                  continue;
               } else {
                  return -1;
               }
            }
            return 1;
         }
      }
      return -1;
   }

   public static int validateDecimalCode(String code) {
      if (code.startsWith("rgb(") && code.endsWith(")")) {
         code = code.substring(4, code.length() - 1);
         String ranges[] = code.split(",");
         for (String str : ranges) {
            try {
               int number = Integer.parseInt(str);
               if (number >= 0 && number <= 255) {
                  continue;
               } else {
                  return -1;
               }
            } catch (Exception e) {
               return -1;
            }
         }
         return 1;
      }
      return -1;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int ch = scanner.nextInt();
      scanner.nextLine();
      if (ch == 1) {
         int r = validateHexCode(scanner.nextLine());
         if (r == 1) {
            System.out.println("Valid Code");
         } else {
            System.out.println("Invalid Code");
         }
      } else if (ch == 2) {
         int r = validateDecimalCode(scanner.nextLine());
         if (r == 1) {
            System.out.println("Valid Code");
         } else {
            System.out.println("Invalid Code");
         }
      } else {
         System.out.println("Invalid choice");
      }
   }
}