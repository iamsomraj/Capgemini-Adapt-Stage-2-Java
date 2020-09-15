// 100% score

import java.util.Scanner;

interface CustomerService {
   void rent(int toyId);

   void display();
}

class Toy {
   private int toyId;
   private String toyName;
   private String toyType;
   private int minAge;
   private int maxAge;
   private double price;
   private int rentalAmt;
   private int refundableDeposit;
   private int quantity;

   public Toy(int toyId, String toyName, String toyType, int minAge, int maxAge, double price, int refundableDeposit,
         int quantity, int rentalAmt) {
      this.toyId = toyId;
      this.toyName = toyName;
      this.toyType = toyType;
      this.minAge = minAge;
      this.maxAge = maxAge;
      this.price = price;
      this.rentalAmt = rentalAmt;
      this.refundableDeposit = refundableDeposit;
      this.quantity = quantity;
   }

   public int getToyId() {
      return toyId;
   }

   public String getToyName() {
      return toyName;
   }

   public String getToyType() {
      return toyType;
   }

   public int getQuantity() {
      return quantity;
   }

   public int getRentalAmount() {
      return rentalAmt;
   }

   public void setToyId(int toyId) {
      this.toyId = toyId;
   }

   public void setToyName(String toyName) {
      this.toyName = toyName;
   }

   public void setToyType(String toyType) {
      this.toyType = toyType;
   }

   public int getMinAge() {
      return minAge;
   }

   public void setMinAge(int minAge) {
      this.minAge = minAge;
   }

   public int getMaxAge() {
      return maxAge;
   }

   public void setMaxAge(int maxAge) {
      this.maxAge = maxAge;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public int getRentalAmt() {
      return rentalAmt;
   }

   public void setRentalAmt(int rentalAmt) {
      this.rentalAmt = rentalAmt;
   }

   public int getRefundableDeposit() {
      return refundableDeposit;
   }

   public void setRefundableDeposit(int refundableDeposit) {
      this.refundableDeposit = refundableDeposit;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
}

class CustomerServiceImpl implements CustomerService {
   public static Toy availableToys[] = new Toy[4];
   public Toy customerToysRentalInfo[] = new Toy[2];

   CustomerServiceImpl() {
      availableToys[0] = new Toy(120, "Rubber Ducky", "Toy", 1, 3, 200, 20, 200, 20);
      availableToys[1] = new Toy(130, "Car", "Toy", 1, 5, 100, 30, 20, 100);
      availableToys[2] = new Toy(150, "Kite", "Toy", 3, 8, 100, 50, 20, 100);
      availableToys[3] = new Toy(180, "Airplane", "Toy", 4, 7, 500, 30, 50, 20);
   }

   public void rent(int toyId) {
      for (int i = 0; i < 4; i++) {
         if (availableToys[i].getToyId() == toyId) {
            System.out.println("Toy Name: " + availableToys[i].getToyName());
            System.out.println("Toy Type: " + availableToys[i].getToyType());
            System.out.println("Quantity: " + availableToys[i].getQuantity());
            System.out.print("RentalAmount: " + availableToys[i].getRentalAmount());
            break;
         }
      }
   }

   public void display() {

   }
}

public class Source {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int toyId = scanner.nextInt();
      CustomerService cs = new CustomerServiceImpl();
      cs.rent(toyId);
   }
}
