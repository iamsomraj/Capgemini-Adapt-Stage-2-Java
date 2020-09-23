import java.util.*;

class Product {
   private String productCode;
   private String productName;
   private double productPrice;
   private char categoryCode;
   private static int prodCounter = 100;

   public String getProductCode() {
      return this.productCode;
   }

   public String getProductName() {
      return this.productName;
   }

   public double getProductPrice() {
      return this.productPrice;
   }

   public char getCategoryCode() {
      return this.categoryCode;
   }

   public void setProductCode(String productCode) {
      this.productCode = productCode;
   }

   public void setProductName(String productName) {
      this.productName = productCode;
   }

   public void setProductPrice(double productPrice) {
      this.productPrice = productPrice;
   }

   public void setCategoryCode(char categoryCode) {
      this.categoryCode = categoryCode;
   }

   public String generateProductCode(char categoryCode) {
      prodCounter++;
      return String.valueOf(prodCounter) + categoryCode;
   }

   public Product(String productName, double productPrice, char categoryCode) {
      this.productCode = this.generateProductCode(categoryCode);
      setProductName(productName);
      setProductPrice(productPrice);
      setCategoryCode(categoryCode);
   }

   public Product(String productName, double productPrice) {
      this.productCode = this.generateProductCode('E');
      setProductName(productName);
      setProductPrice(productPrice);
      setCategoryCode('E');
   }

   public String getProductDetails() {
      return "Code-" + getProductCode() + ", Name-" + getProductName() + ", Price-" + getProductPrice() + ", Category-"
            + getCategoryCode();
   }

}

/**
 * Source
 */
public class Source {

   public static void main(String[] args) {
      Product p = new Product("Laptop", 45000.0, 'E');
      System.out.println(p.getProductDetails());
   }
}