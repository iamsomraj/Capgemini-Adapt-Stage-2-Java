// could not understand the project structure

import java.util.Scanner;

class Customer {
   private int customerId;
   private String customerName;
   private String email;
   private String password;
   private String address;

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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
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

   public Customer(int customerId, String customerName, String email, String password, String address) {
      this.customerId = customerId;
      this.customerName = customerName;
      this.email = email;
      this.password = password;
      this.address = address;
   }

   public Customer() {
   }

}

class Admin {
   private String name;
   private String email;
   private String password;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Admin(String name, String email, String password) {
      this.name = name;
      this.email = email;
      this.password = password;
   }

   public Admin() {

   }

}

class AdminServiceImpl {
   public static Admin[] adminArray = new Admin[5];

   AdminServiceImpl() {
      adminArray[0] = new Admin("Krithick", "krithick@gmail.com", "krithi");
      adminArray[1] = new Admin("Rajan", "rajan@gmail.com", "rajan#345");
      adminArray[2] = new Admin("Chandrav", "chand@gmail.com", "wel$234");
      adminArray[3] = new Admin("Ankit", "ankit@gmail.com", "kit@56");
      adminArray[4] = new Admin("Akilan", "akilan@gmail.com", "ak*76");
   }

   public boolean validateAdmin(String email, String password) {
      for (Admin adm : adminArray) {
         if (adm.getEmail().equals(email) && adm.getPassword().equals(password)) {
            return true;
         }
      }

      return false;
   }   

}


class CustomerService extends Customer {
   public static Customer[] customerArray = new Customer[5];

   public CustomerService() {
      customerArray[0] = new Customer(100, "Karthi", "kar@gmail.com", "kar#2", "Bangalore");
      customerArray[1] = new Customer(101, "Kumar", "km@mail.com", "km#2", "Bangalore");
      customerArray[2] = new Customer(102, "Rakesh", "rak@mail.com", "rak#45", "Chennai");
      customerArray[3] = new Customer(103, "Rakshan", "shan@mail.com", "an#2", "Mumbai");
      customerArray[4] = new Customer(104, "Virat", "rat@mail.com", "at#45", "Pune");

   }

   public boolean validateCustomer(String email, String password) {
      for (Customer cust : customerArray) {
         if (cust.getEmail().equals(email) && cust.getPassword().equals(password)) {
            return true;
         }
      }
      return false;
   }
}

public class Source {
   public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      int choice = Integer.parseInt(scanner.nextLine());
      if (choice == 1) {
         CustomerService customerService = new CustomerService();
         if (customerService.validateCustomer(scanner.nextLine(), scanner.nextLine())) {
            System.out.println("1.Rent Toys\n2.Rental Information");
         }
      } else {
         AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
         if (adminServiceImpl.validateAdmin(scanner.nextLine(), scanner.nextLine())) {
            System.out.println("1.Insert Toys\n2.Update Toys\n3.Delete Toys\n4.Search Toys");
         }
      }
   }
}