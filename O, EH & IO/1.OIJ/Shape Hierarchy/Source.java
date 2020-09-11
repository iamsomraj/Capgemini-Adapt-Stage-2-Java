import java.util.*;

interface Shape {
   double getArea();

   double getPerimeter();
}

abstract class AbstractShape implements Shape {
   private String colour;

   AbstractShape(String color) {
      this.colour = color;
   }

   @Override
   public String toString() {
      return ("colour=" + this.colour);
   }

   public String getColour() {
      return colour;
   }
}

class Rectangle extends AbstractShape {
   private int length;
   private int breadth;

   Rectangle(String colour, int len, int bre) {
      super(colour);
      this.length = len;
      this.breadth = bre;
   }

   @Override
   public double getArea() {
      return ((double) this.length * this.breadth);
   }

   @Override
   public double getPerimeter() {
      return ((double) (2 * (this.length + this.breadth)));
   }

   @Override
   public String toString() {
      String result = "Rectangle [colour=" + this.getColour() + ", length=" + this.length + ", breadth=" + this.breadth
            + "]";
      return result;
   }
}

class Circle extends AbstractShape {
   private int radius;

   Circle(String colour, int rad) {
      super(colour);
      this.radius = rad;
   }

   @Override
   public double getArea() {
      return ((double) Math.PI * radius * radius);
   }

   @Override
   public double getPerimeter() {
      return ((double) (2 * Math.PI * radius));
   }

   @Override
   public String toString() {
      String result = "Circle [colour=" + this.getColour() + ", radius=" + this.radius + "]";
      return result;
   }
}

class Source {
   public static void printShape(AbstractShape abs) {
      System.out.println("Area: " + Math.round(abs.getArea()) + ",Perimeter: " + Math.round(abs.getPerimeter()));
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String type = sc.nextLine();
      String input[] = sc.nextLine().split(" ");
      if (type.equals("CIRCLE")) {
         Circle circle = new Circle(input[0], Integer.parseInt(input[1]));
         printShape(circle);
      } else {
         Rectangle rectangle = new Rectangle(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
         printShape(rectangle);
      }
   }
}