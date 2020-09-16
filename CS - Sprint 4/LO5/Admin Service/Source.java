// 100 % score

import java.util.*;

interface AdminService {
   void addToy(Toy toy);

   void updateToy(Toy toy);

   void deleteToy(Toy toy);

   Toy[] getToys();
}

class AdminServiceImpl implements AdminService {
   public static Toy[] toyArray = new Toy[5];
   public static int count = 0;

   @Override
   public void addToy(Toy toy) {
      toyArray[count] = toy;
      count++;
   }

   public void updateToy(Toy toy) {
      for (int i = 0; i <= count; i++) {
         if (toyArray[i].getToyId() == toy.getToyId()) {
            toyArray[i] = toy;
            break;
         }
      }
   }

   public void deleteToy(Toy toy) {
      for (int i = 0; i <= count; i++) {
         if (toyArray[i].getToyId() == toy.getToyId()) {
            toyArray[i] = null;
            break;
         }
      }
   }

   public Toy[] getToys() {
      return toyArray;
   }

}

class Toy {
   private int toyId, minAge, maxAge, quantity;
   private String toyName, toyType;
   private double price, rentalAmount, refundableDeposit;

   Toy(int id, String name, String type, int min, int max, double price, int quant, double rent, double refund) {
      this.toyId = id;
      this.toyName = name;
      this.toyType = type;
      this.minAge = min;
      this.maxAge = max;
      this.price = price;
      this.quantity = quant;
      this.rentalAmount = rent;
      this.refundableDeposit = refund;
   }

   public int getToyId() {
      return toyId;
   }

   public void setToyId(int toyId) {
      this.toyId = toyId;
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

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
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

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public double getRentalAmount() {
      return rentalAmount;
   }

   public void setRentalAmount(double rentalAmount) {
      this.rentalAmount = rentalAmount;
   }

   public double getRefundableDeposit() {
      return refundableDeposit;
   }

   public void setRefundableDeposit(double refundableDeposit) {
      this.refundableDeposit = refundableDeposit;
   }

   public String toString() {
      return ("Toy Name: " + this.toyName + "\nToy Type: " + this.toyType + "\nQuantity: " + this.quantity
            + "\nRentalAmount: " + this.rentalAmount);
   }

}

class Source {
   public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      int choice = s.nextInt();
      int id, min, max, quantity;
      String name, type;
      double price, rent, refund;
      Toy[] toys;
      switch (choice) {
         case 1:
            if (s.hasNext()) {
               id = s.nextInt();
               name = s.next();
               type = s.next();
               min = s.nextInt();
               max = s.nextInt();
               price = s.nextDouble();
               quantity = s.nextInt();
               rent = s.nextDouble();
               refund = s.nextDouble();
               Toy t = new Toy(id, name, type, min, max, price, quantity, rent, refund);
               AdminService adm = new AdminServiceImpl();
               adm.addToy(t);
               toys = adm.getToys();
               for (int i = 0; i < toys.length; i++) {
                  System.out.println(adm.toString());
               }
            }
            break;
         case 2:
            id = s.nextInt();
            name = s.next();
            type = s.next();
            min = s.nextInt();
            max = s.nextInt();
            price = s.nextDouble();
            quantity = s.nextInt();
            rent = s.nextDouble();
            refund = s.nextDouble();
            Toy t1 = new Toy(id, name, type, min, max, price, quantity, rent, refund);
            AdminService adm1 = new AdminServiceImpl();
            adm1.updateToy(t1);
            System.out.println(adm1.toString());
            break;
         case 3:
            id = s.nextInt();
            name = s.next();
            type = s.next();
            min = s.nextInt();
            max = s.nextInt();
            price = s.nextDouble();
            quantity = s.nextInt();
            rent = s.nextDouble();
            refund = s.nextDouble();
            Toy t2 = new Toy(id, name, type, min, max, price, quantity, rent, refund);
            AdminService adm2 = new AdminServiceImpl();
            adm2.deleteToy(t2);
            break;
         case 4:

            AdminService adm3 = new AdminServiceImpl();
            toys = adm3.getToys();
            for (int i = 0; i < toys.length; i++) {
               System.out.println(adm3.toString());
            }
      }
      s.close();
   }
}