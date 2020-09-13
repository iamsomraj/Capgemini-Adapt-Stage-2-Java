// -___-
// test cases have syntax error

import java.util.*;

interface AdminService {
   public void addToy(Toy toy);

   public void updateToy(Toy toy);

   public void deleteToy(int toyId);

   public Toy[] getToys(Toy toy);
}

class Toy {
   private int toyId;
   private String toyName;
   private String toyType;
   private int minAge;
   private int maxAge;
   private float price;
   private int quantity;
   private float rentalAmount;
   private float refundableDeposit;

   public int getToyId() {
      return toyId;
   }

   public void setToyId(int toyId) {
      this.toyId = toyId;
   }

   public String getToyName() {
      return toyName;
   }

   public void setToyName(String toyName) {
      this.toyName = toyName;
   }

   public String getToyType() {
      return toyType;
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

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public float getRentalAmount() {
      return rentalAmount;
   }

   public void setRentalAmount(float rentalAmount) {
      this.rentalAmount = rentalAmount;
   }

   public float getRefundableDeposit() {
      return refundableDeposit;
   }

   public void setRefundableDeposit(float refundableDeposit) {
      this.refundableDeposit = refundableDeposit;
   }

   public Toy(int toyId, String toyName, String toyType, int minAge, int maxAge, float price, int quantity,
         float rentalAmount, float refundableDeposit) {
      this.toyId = toyId;
      this.toyName = toyName;
      this.toyType = toyType;
      this.minAge = minAge;
      this.maxAge = maxAge;
      this.price = price;
      this.quantity = quantity;
      this.rentalAmount = rentalAmount;
      this.refundableDeposit = refundableDeposit;
   }

   @Override
   public String toString() {
      String result = "";
      result += "ToyName: " + toyName + "\n";
      result += "ToyType: " + toyType + "\n";
      result += "Quantity: " + quantity + "\n";
      result += "RentalAmount: " + rentalAmount;
      return result;
   }

   public Toy() {

   }

}

class AdminServiceImpl implements AdminService {
   public static Toy[] toyArray;
   public static ArrayList<Toy> toys = new ArrayList<Toy>();

   @Override
   public void addToy(Toy toy) {
      toys.add(toy);
      updateToyArray();
   }

   @Override
   public void deleteToy(int toyId) {
      for (int i = 0; i < toys.size(); i++) {
         if (toys.get(i).getToyId() == toyId) {
            toys.remove(i);
         }
      }
      updateToyArray();
   }

   @Override
   public Toy[] getToys(Toy toy) {
      return toyArray;
   }

   @Override
   public void updateToy(Toy toy) {
      for (int i = 0; i < toys.size(); i++) {
         if (toys.get(i).getToyId() == toy.getToyId()) {
            toys.set(i, toy);
         }
      }
      updateToyArray();
   }

   public void display() {
      for (Toy toy : toyArray) {
         System.out.println(toy);
      }
   }

   public static void updateToyArray() {
      toyArray = new Toy[toys.size()];
      int i = 0;
      for (Toy t : toys) {
         toyArray[i] = t;
         i++;
      }
   }

}

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

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int toyId = Integer.parseInt(scanner.nextLine());
      String toyName = scanner.nextLine();
      String toyType = scanner.nextLine();
      int minAge = Integer.parseInt(scanner.nextLine());
      int maxAge = Integer.parseInt(scanner.nextLine());
      float price = Float.parseFloat(scanner.nextLine());
      int quantity = Integer.parseInt(scanner.nextLine());
      float rentalAmount = Float.parseFloat(scanner.nextLine());
      float refundableDeposit = Float.parseFloat(scanner.nextLine());
      Toy toy = new Toy(toyId, toyName, toyType, minAge, maxAge, price, quantity, rentalAmount, refundableDeposit);
      AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
      adminServiceImpl.addToy(toy);
      adminServiceImpl.display();
   }

}
