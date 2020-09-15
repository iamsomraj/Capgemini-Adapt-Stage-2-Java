// 0 score

import java.util.*;

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
      result += "Id: " + toyId + "\n";
      result += "Toy Name: " + toyName;
      return result;
   }

   public Toy() {

   }

}

interface AdminService {
   boolean validateAdmin(String email, String password);

   Toy searchToy(int toyId);
}

interface CustomerService {
   boolean validateCustomer(String email, String password);

   Customer searchCustomer(int CustomerId);
}

class Customer {
   private int customerId;
   private String customerName;
   private String email;
   private String password;
   private String address;

   public Customer(int customerId, String customerName, String email, String password, String address) {
      this.customerId = customerId;
      this.customerName = customerName;
      this.password = password;
      this.address = address;
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public String getEmail() {
      return email;
   }

   public int getCustomerId() {
      return customerId;
   }

   public void setCustomerId(int customerId) {
      this.customerId = customerId;
   }

   public String getCustomerName() {
      return customerName;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   @Override
   public String toString() {
      return "Id: " + customerId + "\nName: " + customerName;
   }

}

class Admin {
   private String name;
   private String email;
   private String password;

   public Admin(String name, String email, String password) {
      this.password = password;
      this.name = name;
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public String getEmail() {
      return email;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "Admin [email=" + email + ", name=" + name + ", password=" + password + "]";
   }

}

class AdminServiceImpl extends CustomerServiceImpl implements AdminService {
   static Toy availableToys[] = new Toy[4];

   public static Admin[] adminArray = new Admin[5];

   AdminServiceImpl() {
      adminArray[0] = new Admin("Krithick", "krithick@gmail.com", "krithi");
      adminArray[1] = new Admin("Rajan", "rajan@gmail.com", "rajan#345");
      adminArray[2] = new Admin("Chandrav", "chand@gmail.com", "wel$234");
      adminArray[3] = new Admin("Ankit", "ankit@gmail.com", "kit@56");
      adminArray[4] = new Admin("Akilan", "akilan@gmail.com", "ak*76");
      availableToys[0] = new Toy(120, "Rubber Ducky", "Toy", 1, 3, 200, 20, 20, 200);
      availableToys[1] = new Toy(130, "Car", "Toy", 1, 5, 100, 30, 20, 100);
      availableToys[2] = new Toy(150, "Kite", "Toy", 3, 8, 100, 50, 20, 50);
      availableToys[3] = new Toy(180, "Airplane", "Toy", 4, 7, 500, 30, 50, 20);
   }

   public boolean validateAdmin(String email, String password) {
      for (Admin a : adminArray) {
         if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
            return true;
         }
      }
      return false;
   }

   public Toy searchToy(int toyId) {
      for (Toy toy : availableToys) {
         if (toy.getToyId() == toyId) {
            return toy;
         }
      }
      return null;
   }

}

class CustomerServiceImpl implements CustomerService {
   public static Customer[] customerArray = new Customer[5];

   public CustomerServiceImpl() {
      customerArray[0] = new Customer(100, "Karthi", "kar@gmail.com", "kar#2", "Bangalore");
      customerArray[1] = new Customer(101, "Kumar", "km@mail.com", "km#2", "Bangalore");
      customerArray[2] = new Customer(102, "Rakesh", "rak@mail.com", "rak#45", "Chennai");
      customerArray[3] = new Customer(103, "Rakshan", "shan@mail.com", "an#2", "Mumbai");
      customerArray[4] = new Customer(104, "Virat", "rat@mail.com", "at#45", "Pune");

   }

   public Customer searchCustomer(int CustomerId) {
      for (Customer Customer : customerArray) {
         if (Customer.getCustomerId() == CustomerId) {
            return Customer;
         }
      }
      return null;
   }

   public boolean validateCustomer(String email, String password) {
      for (Customer c : customerArray) {
         if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
            return true;
         }
      }
      return false;
   }
}

public class Source {
   public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      if (n == 1) {
         CustomerServiceImpl customerService = new CustomerServiceImpl();
         Customer customer = customerService.searchCustomer(scanner.nextInt());
         System.out.println(customer);

      } else if (n == 2) {
         AdminServiceImpl adminService = new AdminServiceImpl();
         Toy toy = adminService.searchToy(scanner.nextInt());
         System.out.println(toy);
      }
   }

}
