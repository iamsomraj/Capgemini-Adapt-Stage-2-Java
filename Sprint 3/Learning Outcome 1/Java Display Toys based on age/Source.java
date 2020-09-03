import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Source {
   String[][] toys = new String[5][5];

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

   public String getToy(int age) {
      for (String[] toyDetail : toys) {
         if (Integer.parseInt(toyDetail[0]) == age) {
            return toyDetail[1];
         }
      }
      return "no toys available";
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int inputNumber = scanner.nextInt();
      System.out.println(new Source().getToy(inputNumber));
   }
}
