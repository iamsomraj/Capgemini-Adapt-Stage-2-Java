class Customer {
   // STUDENT CODE BEGINS HERE
   private int customerId;
   private String name;
   private String city;
   private String phone;
   private String email;

   // Default constructor
   Customer() {
      this.customerId = Integer.MIN_VALUE;
      this.name = null;
      this.city = null;
      this.phone = null;
      this.email = null;
   }

   // Parametrized constructor
   Customer(int customerId, String name, String city, String phone, String email) {
      this.customerId = customerId;
      this.name = name;
      this.city = city;
      this.phone = phone;
      this.email = email;
   }

   public String getCity() {
      return city;
   }

   public int getCustomerId() {
      return customerId;
   }

   public String getEmail() {
      return email;
   }

   public String getName() {
      return name;
   }

   public String getPhone() {
      return phone;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public void setCustomerId(int customerId) {
      this.customerId = customerId;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   @Override // Equals method
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (this == (Customer) obj) {
         return true;
      }
      Customer cust = (Customer) obj;
      return (this.hashCode() == cust.hashCode());
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result *= prime;
      if (customerId != Integer.MIN_VALUE)
         result *= Integer.hashCode(customerId);
      if (city != null)
         result *= city.hashCode();
      if (name != null)
         result *= name.hashCode();
      if (phone != null)
         result *= phone.hashCode();
      if (email != null)
         result *= email.hashCode();
      return result;
   }
   // STUDENT CODE ENDS HERE
}

class Source {
   public static void main(String[] args) {
      Customer c1 = new Customer(1, "Vinod", "Bangalore", null, null);
      Customer c2 = new Customer(1, "Vinod", "Bangalore", null, null);

      // Equals
      boolean b1 = c1.equals(c2);
      boolean b2 = c2.equals(c1);

      // Setter and Equals
      c1.setEmail("vinod@mailinator.com");
      boolean b3 = c1.equals(c2);
      boolean b4 = c2.equals(c1);

      c2.setEmail("vinod@mailinator.com");
      boolean b5 = c1.equals(c2);
      boolean b6 = c2.equals(c1);

      // Default Constructor
      Customer c3 = new Customer();
      Customer c4 = new Customer();
      boolean b7 = c3.equals(c4);

      System.out.println(b1);
      System.out.println(b2);
      System.out.println(b3);
      System.out.println(b4);
      System.out.println(b5);
      System.out.println(b6);
      System.out.println(b7);
   }
}
