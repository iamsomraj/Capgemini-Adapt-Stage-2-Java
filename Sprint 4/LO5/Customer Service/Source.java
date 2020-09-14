// no points - but program works
import java.util.*;

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

class CustomerServiceImpl implements CustomerService {
   public static Toy availableToys[] = new Toy[4];
   public Toy customerToysRentalInfo[] = new Toy[2];
   public static int i = 0;

   CustomerServiceImpl() {
      availableToys[0] = new Toy(120, "Rubber Ducky", "Toy", 1, 3, 200, 20, 20, 200);
      availableToys[1] = new Toy(130, "Car", "Toy", 1, 5, 100, 30, 20, 100);
      availableToys[2] = new Toy(150, "Kite", "Toy", 3, 8, 100, 50, 20, 50);
      availableToys[3] = new Toy(180, "Airplane", "Toy", 4, 7, 500, 30, 50, 20);
   }

   public void rent(int toyId) {
      for (Toy toy : availableToys) {
         if (toy.getToyId() == toyId) {
            customerToysRentalInfo[i++] = toy;
            return;
         }
      }
   }

   public void display() {
      for (Toy t : customerToysRentalInfo) {
         if (t != null)
            System.out.println(t);
      }
   }
}

public class Source {
   public static void main(String[] args) {
      CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
      customerServiceImpl.rent(150);
      customerServiceImpl.rent(120);
      customerServiceImpl.display();
   }
}
