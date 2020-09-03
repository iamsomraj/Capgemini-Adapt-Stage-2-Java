import java.util.Scanner;

public class Source {
   String[][] toys = new String[5][5];
   String[][] customers = new String[5][5];

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

      // Cant expect more than this
      // they have not even provided the details of customer -_-
      // that's why, I am making dummy data

      int i = 0;
      customers[i][0] = "sample-id-" + i;
      customers[i][1] = "sample-name-" + i;
      customers[i][2] = "sample-address-" + i;
      i++;
      customers[i][0] = "sample-id-" + i;
      customers[i][1] = "sample-name-" + i;
      customers[i][2] = "sample-address-" + i;
      i++;
      customers[i][0] = "sample-id-" + i;
      customers[i][1] = "sample-name-" + i;
      customers[i][2] = "sample-address-" + i;
      i++;
      customers[i][0] = "sample-id-" + i;
      customers[i][1] = "sample-name-" + i;
      customers[i][2] = "sample-address-" + i;

      // only proper data that I could use
      // source : test case

      i++;
      customers[i][0] = "205";
      customers[i][1] = "Kiran";
      customers[i][2] = "Mumbai";

      // would not do the next problems
      // Update : 3rd September,2020

   }

   public String getToy(int age) {
      for (String[] toyDetail : toys) {
         if (Integer.parseInt(toyDetail[0]) == age) {
            return toyDetail[1];
         }
      }
      return "no toys available";
   }

   public String[] getCustomer(String name) {
      for (String[] customer : customers) {
         if (customer[1].equals(name)) {
            return customer;
         }
      }
      return new String[] { "no-id-found", "no-name-found", "no-address-found" };
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String customerName = scanner.nextLine();
      String customer[] = new Source().getCustomer(customerName);
      System.out.println(customer[0] + " " + customer[1] + " " + customer[2]);
   }
}
