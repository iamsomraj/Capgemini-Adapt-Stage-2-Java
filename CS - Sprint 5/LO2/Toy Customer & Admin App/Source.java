// thanks

import java.util.*;
import java.io.*;

interface CustomerService {
   void createCustomer(Customer customer);

   List<Customer> getCustomers();

   boolean updateCustomer(Customer customer);

   Customer searchCustomer(int customerId);

   List searchCustomer(String customerName);

   boolean deleteCustomer(int customerId);

   boolean validateCustomer(String email, String password);

   void writeCustomer();

   List<Customer> readCustomer();

   void rent(int toyId);
}

class CustomerServiceImpl implements CustomerService {
   public static ArrayList<Customer> customerList;
   public static ArrayList<Toy> availedToys;

   /*
    * Comparator<Customer> nameComp=new Comparator<Customer>() { public int
    * compare(Customer c1,Customer c2){ return
    * c1.getCustomerName().compareTo(c2.getCustomerName()); } };
    */
   public void createCustomer(Customer customer) {
      customerList.add(customer);
   }

   public List<Customer> getCustomers() {
      return customerList;
   }

   public boolean updateCustomer(Customer customer) {
      for (int i = 0; i < customerList.size(); i++) {
         if (customer.getCustomerId() == customerList.get(i).getCustomerId()) {
            customerList.set(i, customer);
            return true;
         }
      }
      return false;
   }

   public Customer searchCustomer(int customerId) {
      for (Customer c : customerList) {
         if (customerId == c.getCustomerId()) {
            return c;
         }
      }
      return null;
   }

   public List<Customer> searchCustomer(String customerName) {
      List<Customer> temp = new ArrayList<Customer>();
      for (Customer cust : customerList) {
         if (customerName.compareTo(cust.getCustomerName()) == 0) {
            temp.add(cust);
         }
      }
      return temp;
   }

   public boolean deleteCustomer(int customerId) {
      for (int i = 0; i < customerList.size(); i++) {
         if (customerId == customerList.get(i).getCustomerId()) {
            customerList.remove(i);
            return true;
         }
      }
      return false;
   }

   public boolean validateCustomer(String email, String password) {
      for (Customer c : customerList) {
         if (email.compareTo(c.getEmail()) == 0 && password.compareTo(c.getPassword()) == 0) {
            return true;
         }
      }
      return false;
   }

   public void writeCustomer() {
      try {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customer.txt"));
         for (Customer c : customerList) {
            oos.writeObject(c);
         }
         oos.close();
      } catch (FileNotFoundException fnfe) {
         System.out.println("FileNotFoundException");
      } catch (IOException ioe) {
         System.out.println("IOException");
      }
   }

   public List<Customer> readCustomer() {
      try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customer.txt"));
         while (ois.available() > 0) {
            Customer c = (Customer) ois.readObject();
            customerList.add(c);
         }
      } catch (FileNotFoundException fnfe3) {
         System.out.println("FileNotFoundException3");
      } catch (IOException ioe3) {
         System.out.println("IOException3");
      } catch (ClassNotFoundException cnfe) {
         System.out.println("ClassNotFoundException");
      }

      return customerList;
   }

   public void rent(int toyId) {
      int count = 0;
      for (Toy t : AdminServiceImpl.toysList) {
         if (toyId == t.getToyId()) {
            availedToys.add(t);
            count++;
         }
      }
      if (count < 1) {
         try {
            throw new ToysNotFoundException();
         } catch (ToysNotFoundException tnfe) {
            System.out.println(tnfe);
         }
      }
   }
}

interface AdminService {
   void addToys(Toy toy);

   boolean updateToys(Toy toy);

   boolean validateAdmin(String email, String password);

   void writeToy();

   List<Toy> readToy();
}

class AdminServiceImpl implements AdminService {
   public static ArrayList<Admin> adminList;
   public static ArrayList<Toy> toysList;

   public void addToys(Toy toy) {
      toysList.add(toy);
   }

   public boolean updateToys(Toy toy) {
      for (int i = 0; i < toysList.size(); i++) {
         if (toy.getToyId() == toysList.get(i).getToyId()) {
            toysList.set(i, toy);
            return true;
         }
      }
      return false;
   }

   public boolean validateAdmin(String email, String password) {
      for (Admin a : adminList) {
         if (email.compareTo(a.getEmail()) == 0 && password.compareTo(a.getPassword()) == 0) {
            return true;
         }
      }
      return false;
   }

   public void writeToy() {
      try {
         ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("toys.txt"));
         for (Toy t : toysList) {
            oos1.writeObject(t);
         }
         oos1.close();
      } catch (FileNotFoundException fnfe2) {
         System.out.println("FileNotFoundException2");
      } catch (IOException ioe2) {
         System.out.println("IOException2");
      }
   }

   public List<Toy> readToy() {
      try {
         ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("toys.txt"));
         while (ois1.available() > 0) {
            Toy t = (Toy) ois1.readObject();
            toysList.add(t);
         }
      } catch (FileNotFoundException fnfe4) {
         System.out.println("FileNotFoundException4");
      } catch (IOException ioe4) {
         System.out.println("IOException4");
      } catch (ClassNotFoundException cnfe2) {
         System.out.println("ClassNotFoundException2");
      }

      return toysList;
   }
}

public class Source {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      switch (choice) {
         case 1:
            String email = sc.nextLine();
            String password = sc.nextLine();
            Customer c = new Customer();
            CustomerService cs = new CustomerServiceImpl();
            if (!cs.validateCustomer(email, password)) {
               break;
            }

            System.out.println("1.Update Profile\n2.Rent Toy\n3.Rental Details");
            int custChoice = sc.nextInt();
            switch (custChoice) {
               case 1:
                  cs.updateCustomer(c);
                  break;
               case 2:
                  int toyid = sc.nextInt();
                  cs.rent(toyid);
                  break;
               case 3:
                  System.out.println(CustomerServiceImpl.availedToys);
                  break;
               default:
                  System.out.println("Invalid choice");
            }
            break;
         case 2:
            String email2 = sc.nextLine();
            String password2 = sc.nextLine();
            AdminService as = new AdminServiceImpl();
            if (!as.validateAdmin(email2, password2)) {
               break;
            }
            break;
         default:
            System.out.println("Invalid choice");
      }
   }
}

class ToysNotFoundException extends Exception {
   ToysNotFoundException() {
      System.out.println("ToysNotFoundException");
   }
}

class Customer implements Comparable<Customer> {
   private int customerId;
   private String customerName;
   private String email;
   private String password;
   private Address address;

   public Customer() {
   }

   public Customer(int customerId, String customerName, String email, String password, Address address) {
      // super();
      this.customerId = customerId;
      this.customerName = customerName;
      this.password = password;
      this.address = address;
      this.email = email;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "Name: " + customerName + "\tCity: " + address.getCity();
   }

   @Override
   public int compareTo(Customer c) {
      return this.customerId - c.getCustomerId();
   }

}

class Address {
   String city, state, country;
   int zip;

   public Address(String state, String city, int zip, String country) {
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.country = country;

   }

   public void setCity(String city) {
      this.city = city;
   }

   public void setState(String state) {
      this.state = state;
   }

   public void setZip(int zip) {
      this.zip = zip;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getCity() {
      return city;
   }

   public String getState() {
      return state;
   }

   public int getZip() {
      return zip;
   }

   public String getCountry() {
      return country;
   }

   @Override
   public String toString() {
      return getCity() + " " + getState() + " " + getZip() + " " + getCountry() + "";
   }
}

class Toy {
   private int toyId, minAge, maxAge, price, quantity, refundableDeposit, rentalAmount;
   private String toyName, toyType;

   public Toy() {
   }

   public Toy(int toyId, String toyName, String toyType, int minAge, int maxAge, int price, int quantity,
         int rentalAmount, int refundableDeposit) {

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

   public int getToyId() {
      return toyId;
   }

   public void setToyId(int toyId) {
      this.toyId = toyId;
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

   public String getToyName() {
      return toyName;
   }

   public void setToyName(String toyName) {
      this.toyName = toyName;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public int getRefundableDeposit() {
      return refundableDeposit;
   }

   public void setRefundableDeposit(int refundableDeposit) {
      this.refundableDeposit = refundableDeposit;
   }

   public int getRentalAmount() {
      return rentalAmount;
   }

   public void setRentalAmount(int rentalAmount) {
      this.rentalAmount = rentalAmount;
   }

   @Override
   public String toString() {
      return "Toy Name: " + toyName + "\tRent: " + rentalAmount;
   }

   @Override
   public boolean equals(Object t) {
      if (((Toy) t).getToyName().equals(this.toyName)) {
         return true;
      }
      return false;
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = hash + toyName.hashCode();
      return hash;
   }
}

class Admin {
   private String email, password, name;

   public Admin() {

   }

   Admin(String email, String password, String name) {
      this.email = email;
      this.password = password;
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

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
