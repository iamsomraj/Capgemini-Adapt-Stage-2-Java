// Took more than one hour to finish this
// Fork or Star this repo if you find this useful 😃

import java.util.Scanner;

class SimpleDate {
   private int day;
   private int month;
   private int year;

   SimpleDate(int day, int month, int year) {
      this.day = day;
      this.month = month;
      this.year = year;
      validateDate(this);
   }

   public int getDay() {
      return day;
   }

   public int getMonth() {
      return month;
   }

   public int getYear() {
      return year;
   }

   public void setDate(int day, int month, int year) {
      this.day = day;
      this.month = month;
      this.year = year;
   }

   @Override
   public String toString() {
      return (day + "/" + month + "/" + year);
   }

   public static boolean isFebruary(int month) {
      return month == 2;
   }

   public static boolean isValidDay(int month, int day) {
      if (month == 4 || month == 6 || month == 9 || month == 11) {
         if (day >= 1 && day <= 30) {
            return true;
         }
      } else {
         if (day >= 1 && day <= 31) {
            return true;
         }
      }
      return false;
   }

   public static boolean validateDate(SimpleDate sd) {
      int year = sd.getYear();
      int month = sd.getMonth();
      int day = sd.getDay();
      boolean isFebruary = isFebruary(month);
      if (year > 2000 && month >= 1 && month <= 12) {
         if (isFebruary) {
            if (day >= 1 && day <= 28) {
               return true;
            }
         } else if (isValidDay(month, day)) {
            return true;
         }

      }
      return false;
   }
}

class Address {
   private String area;
   private String city;

   Address(String area, String city) {
      this.area = area;
      this.city = city;
   }

   public String getArea() {
      return area;
   }

   public String getCity() {
      return city;
   }

   public void setArea(String area) {
      this.area = area;
   }

   public void setCity(String city) {
      this.city = city;
   }

   @Override
   public String toString() {
      return (area + ", " + city);
   }
}

class Customer {
   private int custId;
   private String name;
   private Address address;
   private SimpleDate registrationDate;

   Customer(int custId, String name, Address address, SimpleDate registrationDate) {
      this.address = address;
      this.custId = custId;
      this.name = name;
      this.registrationDate = registrationDate;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public SimpleDate getRegistrationDate() {
      return registrationDate;
   }

   public void setRegistrationDate(SimpleDate registrationDate) {
      this.registrationDate = registrationDate;
   }

   @Override
   public String toString() {
      String addr = "";
      if (this.address == null) {
         addr = "Unknown";
      } else {
         addr = this.address.toString();
      }
      String reg = "";
      if (this.registrationDate == null) {
         reg = "Unknown";
      } else {
         reg = this.registrationDate.toString();
      }
      String result = String.format("\nId : %d, Name : %s\nAddress : %s\nRegistered on : %s", custId, name, addr,
            reg);
      return (result);
   }

}

/**
 * Source
 */
public class Source {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String first[] = scanner.nextLine().split(" ");
      String second[] = scanner.nextLine().split(" ");
      String third[] = scanner.nextLine().split(" ");
      Address address = new Address(second[0], second[1]);
      SimpleDate simpleDate = new SimpleDate(Integer.parseInt(third[0]), Integer.parseInt(third[1]),
            Integer.parseInt(third[2]));
      Customer customer = new Customer(Integer.parseInt(first[0]), first[1], address, simpleDate);
      System.out.println(customer);
   }
}