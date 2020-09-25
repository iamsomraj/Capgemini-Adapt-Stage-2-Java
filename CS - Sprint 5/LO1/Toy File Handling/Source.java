// Thanks to the person who has done this
import java.io.*;
import java.util.*;

interface AdminService {
   void insertToy(Toy toy);

   void writeToys();

   Toy[] readToys();
}

interface CustomerService {
   void insertCustomer(Customer customer);

   void writeCustomer();

   Customer[] readCustomer();
}

class AdminServiceImpl implements AdminService {
   public static Toy toysArray[] = new Toy[5];
   public static int count = 0;
   File f1 = new File("toys.txt");
   FileOutputStream fos = null;
   FileInputStream fis = null;
   ObjectOutputStream oos = null;
   ObjectInputStream ois = null;

   public void insertToy(Toy toy) {
      toysArray[count] = toy;
      count++;
   }

   public void writeToys() {
      try {
         fos = new FileOutputStream(f1);
      } catch (FileNotFoundException fnfe) {
         System.out.println("FileNotFoundException");
      }
      try {
         oos = new ObjectOutputStream(fos);
         for (int i = 0; i < toysArray.length; i++) {
            if (toysArray[i] != null) {
               oos.writeObject(toysArray[i]);
            } else {
               break;
            }
         }
         oos.close();
      } catch (IOException ioe) {
         System.out.println("IOException");
      }

   }

   public Toy[] readToys() {
      try {
         fis = new FileInputStream(f1);
      } catch (FileNotFoundException fnfe2) {
         System.out.println("FileNotFoundException2");
      }
      try {
         ois = new ObjectInputStream(fis);
         for (int i = 0; i < toysArray.length; i++) {
            if (ois.available() > 0) {
               try {
                  toysArray[i] = (Toy) ois.readObject();
               } catch (ClassNotFoundException cnfe) {
                  System.out.println("ClassNotFoundException");
               }

            } else {
               break;
            }
         }
         ois.close();
      } catch (IOException ioe2) {
         System.out.println("IOException2");
      }

      return toysArray;
   }
}

class CustomerServiceImpl implements CustomerService {
   public static Customer[] customerArray = new Customer[5];
   public static int count = 0;
   File f2 = new File("customer.txt");
   FileOutputStream fos = null;
   FileInputStream fis = null;
   ObjectOutputStream oos = null;
   ObjectInputStream ois = null;

   public void insertCustomer(Customer customer) {
      customerArray[count] = customer;
      count++;
   }

   public void writeCustomer() {
      try {
         fos = new FileOutputStream(f2);
      } catch (FileNotFoundException fnfe3) {
         System.out.println("FileNotFoundException3");
      }
      try {
         oos = new ObjectOutputStream(fos);
         for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i] != null) {
               oos.writeObject(customerArray[i]);
            } else {
               break;
            }
         }
         oos.close();
      } catch (IOException ioe3) {
         System.out.println("IOException3");
      }

   }

   public Customer[] readCustomer() {
      try {
         fis = new FileInputStream(f2);
      } catch (FileNotFoundException fnfe4) {
         System.out.println("FileNotFoundException4");
      }
      try {
         ois = new ObjectInputStream(fis);
         for (int i = 0; i < customerArray.length; i++) {
            if (ois.available() > 0) {
               try {
                  customerArray[i] = (Customer) ois.readObject();
               } catch (ClassNotFoundException cnfe2) {
                  System.out.println("ClassNotFoundException2");
               }

            } else {
               break;
            }
         }
         ois.close();
      } catch (IOException ioe4) {
         System.out.println("IOException4");
      }

      return customerArray;
   }
}

// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
   public static void main(String args[]) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      Scanner sc = new Scanner(System.in);

      // CUSTOMER
      int customerId;
      String customerName, email, password, city;
      // TOYS
      int toyId, minAge, maxAge, price, quantity, refundableDeposit, rentalAmount;
      String toyName, toyType;
      while (sc.hasNext()) {

         int choice = sc.nextInt();
         switch (choice) {
            case 1:
               customerId = sc.nextInt();
               sc.nextLine();
               customerName = sc.nextLine();
               password = sc.nextLine();
               city = sc.nextLine();
               email = sc.nextLine();
               Address add = new Address(null, city, 00000, "India");
               Customer cs = new Customer(customerId, customerName, email, password, add);
               CustomerService csi = new CustomerServiceImpl();
               csi.insertCustomer(cs);
               csi.writeCustomer();
               System.out.println("Successfully Registered");
               break;
            case 2:
               Customer[] custArr = new Customer[CustomerServiceImpl.count];
               CustomerService csi2 = new CustomerServiceImpl();
               custArr = csi2.readCustomer();
               for (int i = 0; i < CustomerServiceImpl.count; i++) {
                  System.out.println(custArr[i]);
               }
               break;

            case 3:
               toyId = sc.nextInt();
               sc.nextLine();
               toyName = sc.nextLine();
               toyType = sc.nextLine();
               minAge = sc.nextInt();
               maxAge = sc.nextInt();
               price = sc.nextInt();
               quantity = sc.nextInt();
               rentalAmount = sc.nextInt();
               refundableDeposit = sc.nextInt();
               Toy t = new Toy(toyId, toyName, toyType, minAge, maxAge, price, quantity, rentalAmount,
                     refundableDeposit);
               AdminService asi = new AdminServiceImpl();
               asi.insertToy(t);
               asi.writeToys();
               System.out.println("Toy added Successfully");
               break;

            case 4:
               Toy[] toyArr = new Toy[AdminServiceImpl.count];
               AdminService asi2 = new AdminServiceImpl();
               toyArr = asi2.readToys();
               for (int i = 0; i < AdminServiceImpl.count; i++) {
                  System.out.println(toyArr[i]);
               }
               break;

            default:
               System.out.println("Invalid choice");
         }

      }

   }
}

class Toy implements Serializable {
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
}

class Customer implements Serializable {
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

}

class Address implements Serializable {
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
