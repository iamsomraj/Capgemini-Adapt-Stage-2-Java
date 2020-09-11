import java.util.*;

class Product {
   private int prodCode;
   private String prodName;
   private double price;
   private String category;

   public Product(int prodCode, String prodName, double price, String category) {
      this.prodCode = prodCode;
      this.prodName = prodName;
      this.price = price;
      this.category = category;
   }

   public int getProdCode() {
      return prodCode;
   }

   public void setProdCode(int prodCode) {
      this.prodCode = prodCode;
   }

   public String getProdName() {
      return prodName;
   }

   public void setProdName(String prodName) {
      this.prodName = prodName;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   @Override
   public String toString() {
      return (this.getProdCode() + " | " + this.getProdName() + " | " + this.getPrice());

   }
}

// DO NOT EDIT THIS CLASS
class ProductData {

   private static Product[] products;

   static {
      products = new Product[8];
      products[0] = new Product(101, "keyboard", 300, "computers");
      products[1] = new Product(102, "mouse", 600, "computers");
      products[2] = new Product(103, "monitor", 5000, "computers");
      products[3] = new Product(104, "t-shirt", 500, "clothing");
      products[4] = new Product(105, "jeans", 2000, "clothing");
      products[5] = new Product(106, "sweater", 1000, "clothing");
      products[6] = new Product(107, "doll", 500, "toys");
      products[7] = new Product(108, "car", 1000, "toys");
   }

   public static Product[] getProducts() {
      return products;
   }
}

class ProductSorter implements Comparator<Product> {
   @Override
   public int compare(Product o1, Product o2) {
      // descending
      return (int) (o2.getPrice() - o1.getPrice());
   }
}

class ProductService {
   public static String findNameByCode(int code) {
      for (Product pdt : ProductData.getProducts()) {
         if (pdt.getProdCode() == code) {
            return pdt.getProdName();
         }
      }
      return null;
   }

   public static Product findMaxPriceProduct(String category) {

      ArrayList<Product> prdts = new ArrayList<Product>();
      for (Product pdt : ProductData.getProducts()) {
         // you have to turn the category into lowercase
         // this is not mentioned in the statement
         if (pdt.getCategory().equals(category.toLowerCase())) {
            prdts.add(pdt);
         }
      }

      if (prdts.size() == 0) {
         return null;
      }

      Collections.sort(prdts, new ProductSorter());
      return prdts.get(0);
   }
}

public class Source {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int option = scanner.nextInt();
      if (option == 1) {
         String result = ProductService.findNameByCode(scanner.nextInt());
         if (result != null) {
            System.out.println(result);
         } else {
            System.out.println("Product Not Found");
         }
      } else if (option == 2) {
         scanner.nextLine();
         Product pdtRes = ProductService.findMaxPriceProduct(scanner.nextLine());
         if (pdtRes != null) {
            System.out.println(pdtRes.getProdCode() + " | " + pdtRes.getProdName() + " | " + pdtRes.getPrice());
         } else {
            System.out.println("No products in given category");
         }
      } else {
         System.out.println("Invalid choice");
      }
   }
}