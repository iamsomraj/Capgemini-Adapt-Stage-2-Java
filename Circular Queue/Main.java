// if you like my work
// then please subscribe to Coding Pillow as a token of appreciation
// and star this repo
// it will make my day :)

// Link - https://www.youtube.com/channel/UCpMMxmD0UWep2B7TfHyn



import java.util.*;

class Main {
   // maximum size
   static int maxSize = 5;
   // my queue
   static int queue[];
   // counter for the number of elements
   static int c = 0;
   // front point to the first space of the queue
   static int front = 0;
   // rear point to the space before front
   static int rear = -1;

   // insert at the rear end
   public static void insert_rear(int item) {
      // check for the max size
      if (c == maxSize) {
         System.out.println("\nThe queue is full!\n");
         // control return to the main
         return;
      }
      // rear inc in circular manner
      rear = (rear + 1) % maxSize;
      // count inc
      c++;
      // insert the item into queue
      queue[rear] = item;
      display();

   }

   public static void delete_front() {
      // check for empty
      if (c == 0) {
         System.out.println("\nThe queue is empty!\n");
         // control return to the main
         return;
      }
      // take the element which is to be deleted
      int ele = queue[front];
      System.out.printf("\nThe element deleted from the queue is %d \n", ele);
      // front inc in circular manner
      front = (front + 1) % maxSize;
      // count dec
      c--;
      display();
   }

   public static void display() {
      // check for empty
      if (c == 0) {
         System.out.println("\nThe queue is empty!\n");
         // control return to the main
         return;
      }
      System.out.println("\n\nQueue details: \n");
      System.out.println("\nFront at:\n" + front);
      System.out.println("\nRear at:\n" + rear);
      // traversing from front to rear
      System.out.println("\n\nThe queue is displayed below: \n");

      // first element will start from front
      int i = front;
      // loop will go for the number of elements, for that j is taken
      for (int j = 1; j <= c; j++) {
         System.out.printf("\t%d\t", queue[i]);
         // i inc in circular manner
         i = (i + 1) % maxSize;
      }

   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("\nSet your queue size:\n");
      // setting max size
      maxSize = sc.nextInt();
      // creating queue
      queue = new int[maxSize];
      int ch = 1;
      while (ch != 4) {
         System.out.println("\n1.Insert at rear\n2.Delete from front\n3.Display\n4.Exit\n");
         ch = sc.nextInt();
         switch (ch) {
            case 1:
               System.out.println("\nEnter item:\n");
               int item = sc.nextInt();
               insert_rear(item);
               break;
            case 2:
               System.out.println("\nDeleting element from front....\n");
               delete_front();
               break;
            case 3:
               System.out.println("\nDisplaying....\n");
               display();
               break;
            case 4:
               System.out.println("\nBye....\n");
               System.exit(2);
            default:
               System.out.println("\nInvalid Input\n");
         }
      }
   }
}