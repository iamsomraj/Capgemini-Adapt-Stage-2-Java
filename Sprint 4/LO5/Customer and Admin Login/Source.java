// 100 % score

import java.util.Scanner;

interface AdminService {
   boolean validateAdmin(String email, String password);
}

interface CustomerService {
   boolean validateCustomer(String email, String password);
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
}

class AdminServiceImpl extends CustomerServiceImpl implements AdminService {
   public static Admin[] adminArray = new Admin[5];

   AdminServiceImpl() {
      adminArray[0] = new Admin("Krithick", "krithick@gmail.com", "krithi");
      adminArray[1] = new Admin("Rajan", "rajan@gmail.com", "rajan#345");
      adminArray[2] = new Admin("Chandrav", "chand@gmail.com", "wel$234");
      adminArray[3] = new Admin("Ankit", "ankit@gmail.com", "kit@56");
      adminArray[4] = new Admin("Akilan", "akilan@gmail.com", "ak*76");
   }

   public boolean validateAdmin(String email, String password) {
      for (Admin a : adminArray) {
         if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
            return true;
         }
      }
      return false;
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
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      if (n == 1) {
         String email = sc.next();
         String password = sc.next();
         CustomerServiceImpl cs = new CustomerServiceImpl();
         boolean flag = cs.validateCustomer(email, password);
         if (flag) {
            System.out.println("1.Rent Toys");
            System.out.println("2.Rental Information for the logged in Customer.");
         }
      } else if (n == 2) {
         String email = sc.next();
         String password = sc.next();
         AdminService as = new AdminServiceImpl();
         boolean flag = as.validateAdmin(email, password);
         if (flag) {
            System.out.println("1.Insert Toys" + "\n2.Update Toys" + "\n3.Delete Toys" + "\n4.Search Toys");
         }
      }
   }

}