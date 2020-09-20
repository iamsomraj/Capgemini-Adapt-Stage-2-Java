// 100 % score

import java.util.*;

class Customer {
   private int customerId;
   private String customerName;
   private String password;
   private Address address;
   private String email;

   public Customer() {
   }

   @Override
   public String toString() {
      String result = customerId + " ";
      result += customerName + " ";
      result += password + " ";
      result += email + "\n";
      result += address;
      return result;
   }

   public Customer(int customerId, String customerName, String password, Address address, String email) {
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

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getpassword() {
      return password;
   }

   public void setpassword(String password) {
      this.password = password;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}

class Address {
   private String city;
   private String state;
   private int zip;
   private String country;

   public Address() {
   }

   public Address(String city, String state, int zip, String country) {
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.country = country;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public int getZip() {
      return zip;
   }

   public void setZip(int zip) {
      this.zip = zip;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   @Override
   public String toString() {
      String result = city + " ";
      result += state + " ";
      result += zip + " ";
      result += country;
      return result;
   }
}

public class Source {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int customerId = Integer.parseInt(scanner.next());
      String customerName = scanner.next();
      String password = scanner.next();
      String email = scanner.next();
      String city = scanner.next();
      String state = scanner.next();
      int zip = Integer.parseInt(scanner.next());
      String country = scanner.next();
      Address address = new Address(city, state, zip, country);
      Customer customer = new Customer(customerId, customerName, password, address, email);
      System.out.println(customer);
   }
}