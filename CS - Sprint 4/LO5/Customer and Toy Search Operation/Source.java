//100% score
import java.util.Scanner;

abstract class AdminService {
   abstract Toy searchToy(int id);
}

abstract class CustomerService {
   abstract Customer searchCustomer(int id);
}

public class Source {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int ch = sc.nextInt();
      int id = sc.nextInt();
      String actualresult = "";
      AdminService asi = new AdminServiceImpl();
      CustomerService csi = new CustomerServiceImpl();
      if (ch == 1) {
         Customer customer = new Customer();
         customer = csi.searchCustomer(id);
         actualresult = customer.toString();
         System.out.println(actualresult);
      }
      if (ch == 2) {
         Toy toy = asi.searchToy(id);
         actualresult = toy.toString;
         System.out.println(actualresult);
      }
   }
}

class Customer {
   private int customerId;
   private String customerName;
   private String email;
   private String password;
   private String address;

   public Customer() {

   }

   public Customer(int customerId, String customerName, String email, String password, String address) {
      super();
      this.customerId = customerId;
      this.customerName = customerName;
      this.email = email;
      this.password = password;
      this.address = address;
   }

   public int getCustomerId() {
      return customerId;
   }

   public String getCustomerName() {
      return customerName;
   }

   @Override
   public String toString() {
      return "Id: " + customerId + "\nName: " + customerName;
   }
}

class Toy {
   int toyId;
   String toyName;
   String toyType;
   int minAge;
   int maxAge;
   double price;
   int rentalAmt;
   int refundableDeposit;
   int quantity;
   String toString;

   public Toy() {

   }

   public Toy(int toyId, String toyName, String toyType, int minAge, int maxAge, double price, int rentalAmt,
         int refundableDeposit, int quantity) {
      this.toyId = toyId;
      this.toyName = toyName;
      this.toyType = toyType;
      this.minAge = minAge;
      this.maxAge = maxAge;
      this.price = price;
      this.rentalAmt = rentalAmt;
      this.refundableDeposit = refundableDeposit;
      this.quantity = quantity;
      this.toString = "Id: " + this.toyId + "\nToyName: " + this.toyName;
   }

   public int getToyId() {
      return toyId;
   }

   public String getToyName() {
      return toyName;
   }

   @Override
   public String toString() {
      return "Id: " + toyId + "\nToyName: " + toyName;
   }
}

class CustomerServiceImpl extends CustomerService {
   public static Customer[] customerArray = new Customer[5];

   public CustomerServiceImpl() {
      customerArray[0] = new Customer(100, "Krithick", "kar@gmail.com", "kar#2", "Bangalore");
      customerArray[1] = new Customer(101, "Kumar", "km@mail.com", "km#2", "Bangalore");
      customerArray[2] = new Customer(102, "Rakesh", "rak@mail.com", "rak#45", "Chennai");
      customerArray[3] = new Customer(103, "Rakshan", "shan@mail.com", "an#2", "Mumbai");
      customerArray[4] = new Customer(104, "Virat", "rat@mail.com", "at#45", "Pune");
   }

   public Customer searchCustomer(int id) {
      for (int i = 0; i < 5; i++) {
         if (customerArray[i].getCustomerId() == id) {
            return customerArray[i];
         }
      }
      return null;
   }
}

class AdminServiceImpl extends AdminService {
   static Toy availableToys[] = new Toy[5];
   Toy toy = new Toy();

   AdminServiceImpl() {
      availableToys[0] = new Toy(120, "Rubber Ducky", "Toy", 1, 3, 200, 20, 20, 200);
      availableToys[1] = new Toy(130, "Car", "Toy", 1, 5, 100, 30, 20, 100);
      availableToys[2] = new Toy(150, "Kite", "Toy", 3, 8, 100, 50, 20, 50);
      availableToys[3] = new Toy(180, "Airplane", "Toy", 4, 7, 500, 30, 50, 20);
   }

   public Toy searchToy(int id) {
      for (int i = 0; i < 4; i++) {
         if (availableToys[i].getToyId() == id) {
            return availableToys[i];
         }
      }
      return null;
   }
}
