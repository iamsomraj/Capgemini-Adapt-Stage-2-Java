import java.util.Scanner;

public class Source {
   static String[][] toys = new String[5][5];
   static String[][] customers = new String[5][3];

   Source() {
      toys[0][0] = "1";
      toys[0][1] = "Stickle Bricks";

      toys[1][0] = "2";
      toys[1][1] = "Robot Dog";

      toys[2][0] = "3";
      toys[2][1] = "Magic 8 Ball";

      toys[3][0] = "4";
      toys[3][1] = "Juggling Clubs";

      toys[4][0] = "5";
      toys[4][1] = "Chutes and Ladders";

   }

   public static String[] getCustomer(String name) {

      customers[0][0] = "102";
      customers[0][1] = "Krithick";
      customers[0][2] = "Bangalore";

      customers[1][0] = "105";
      customers[1][1] = "Prabu";
      customers[1][2] = "Chennai";

      customers[2][0] = "252";
      customers[2][1] = "Chandrav";
      customers[2][2] = "Delhi";

      customers[3][0] = "205";
      customers[3][1] = "Kiran";
      customers[3][2] = "Mumbai";

      customers[4][0] = "202";
      customers[4][1] = "Shravan";
      customers[4][2] = "Pune";

      for (String cust[] : customers) {
         if (cust[1].equals(name)) {
            return cust;
         }
      }
      return null;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String customerName = scanner.nextLine();
      String customer[] = getCustomer(customerName);
      System.out.println(customer[0] + " " + customer[1] + " " + customer[2]);
   }
}
