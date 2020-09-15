// 100 % score


import java.util.Scanner;

class Admin {
   private String email;
   private String password;
   private String name;

   public String getEmail() {
      return email;
   }

   public String getName() {
      return name;
   }

   public String getPassword() {
      return password;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Admin(String email, String password, String name) {
      this.email = email;
      this.password = password;
      this.name = name;
   }

   public Admin() {
   }
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
      String result = "ID: " + toyId + "\n";
      result += "ToyName: " + toyName + "\n";
      result += "ToyType: " + toyType + "\n";
      result += "Min Age: " + minAge + "\n";
      result += "Max Age: " + maxAge + "\n";
      result += "Price: " + price + "\n";
      result += "Quantity: " + quantity + "\n";
      result += "RentalAmount: " + rentalAmount + "\n";
      result += "Refundable Deposit: " + refundableDeposit;
      return result;
   }

   public Toy() {
      
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
      int toyId = scanner.nextInt();
      String toyName = scanner.nextLine();
      scanner.nextLine();
      String toyType = scanner.nextLine();
      int minAge = scanner.nextInt();
      int maxAge = scanner.nextInt();
      float price = scanner.nextFloat();
      int quantity = scanner.nextInt();
      float rentalAmount = scanner.nextFloat();
      float refundableDeposit = scanner.nextFloat();
      Toy toy = new Toy(toyId, toyName, toyType, minAge, maxAge, price, quantity, rentalAmount, refundableDeposit);
      System.out.println(toy);
   }


}
