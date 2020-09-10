import java.util.*;

class Account {
   int accountNo;
   double balance;
   String accountType;
   static int counter;

   Account(double balance, String accountType) {
      counter++;
      this.accountNo = counter;
      this.balance = balance;
      this.accountType = accountType;
   }

   void depositAmount(double amount) {
      this.balance += amount;
   }

   void printAccountDetails() {
      System.out.println(
            "[Acct No : " + this.accountNo + ", Type : " + this.accountType + ", Balance : " + this.balance + "]");
   }
}


// FY Manipal
// Had to do this
class AccountDetails {
   public static void run() {
      Scanner scanner = new Scanner(System.in);
      String first[] = scanner.nextLine().split(" ");
      String second[] = scanner.nextLine().split(" ");
      Account f = new Account(Double.parseDouble(first[0]), first[1]);
      f.depositAmount(Double.parseDouble(first[2]));
      f.printAccountDetails();
      Account ff = new Account(Double.parseDouble(second[0]), second[1]);
      ff.depositAmount(Double.parseDouble(second[2]));
      ff.printAccountDetails();
      scanner.close();
   }
}

class Source {
   public static void main(String args[]) {
      AccountDetails.run();
   }
}
