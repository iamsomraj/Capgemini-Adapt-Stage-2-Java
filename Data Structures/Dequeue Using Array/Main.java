// if you like my work
// then please subscribe to Coding Pillow as a token of appreciation
// and star this repo
// it will make my day :)

// Link - https://www.youtube.com/channel/UCpMMxmD0UWep2B7TfHynvdQ/

import java.util.*;

class Main {
   // maximum size
   static int maxSize = 5;
   // my queue
   static int dequeue[];
   // front point to the first space of the queue
   static int front = 0;
   // rear point to the space before front
   static int rear = -1;

   // insert at the rear end
   public static void insert_rear(int item) {
      // check for filled
      if (rear == maxSize - 1) {
         System.out.println("\nThe double ended queue is full!\n");
         // control return to the main
         return;
      }
      // rear inc
      rear++;
      // item set in new rear
      dequeue[rear] = item;
      display();
   }

   // delete at the front end
   public static void delete_front() {
      // check for empty
      if (front > rear) {
         System.out.println("\nThe double ended queue is empty!\n");
         // control return to the main
         return;
      }
      // store item to be deleted
      int item = dequeue[front];
      System.out.printf("\nThe item deleted from the double ended queue is %d\n", item);
      // front inc
      front++;
      // if list becomes empty after delete
      // set front and rear to the initial state
      if (front > rear) {
         // front set to the first place
         front = 0;
         // rear set to the place before front
         rear = -1;
      }
      display();
   }

   // insert at the front end
   public static void insert_front(int item) {
      // check if the item is the first item to be inserted
      if (front == 0 && rear == -1) {
         // inc rear
         rear++;
         // set the item in rear
         dequeue[rear] = item;
      } else if (front != 0) {
         // when front is not at the first place
         // dec front
         front--;
         // set the item in front
         dequeue[front] = item;
      } else if (rear == maxSize - 1) {
         System.out.println("\nThe double ended queue is full!\n");
         // control return to the main
         return;
      } else if (front == 0) {
         // front points to first place
         // cannot decrease the value
         System.out.println("\nFront of the double ended queue cannot be altered!\n");
         // control return to the main
         return;
      }
      display();
   }

   // delete at the rear end
   public static void delete_rear() {
      // check for empty
      if (front > rear) {
         System.out.println("\nThe double ended queue is empty!\n");
         // control return to the main
         return;
      }
      // store item to be deleted
      int item = dequeue[rear];
      System.out.printf("\nThe item deleted from the double ended queue is %d\n", item);
      // dec rear
      rear--;
      //
      // if list becomes empty after delete
      // set front and rear to the initial state
      if (front > rear) {
         // front set to the first place
         front = 0;
         // rear set to the place before front
         rear = -1;
      }
      display();
   }

   public static void display() {
      // check for empty
      if (front > rear) {
         System.out.println("\nThe double ended queue is empty!\n");
         // control return to the main
         return;
      }
      System.out.println("\n\nQueue details: \n");
      System.out.println("\nFront at:\n" + front);
      System.out.println("\nRear at:\n" + rear);
      // traversing from front to rear
      System.out.println("\n\nThe queue is displayed below: \n");

      // loop will go from front to the rear
      for (int j = front; j <= rear; j++) {
         System.out.printf("\t%d\t", dequeue[j]);
      }

   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("\nSet your queue size:\n");
      // setting max size
      maxSize = sc.nextInt();
      // creating queue
      dequeue = new int[maxSize];
      int ch = 1;
      while (ch != 6) {
         System.out.println(
               "\n1.Insert at rear\n2.Delete from front\n3.Insert at front\n4.Delete at rear\n5.Display\n6.Exit\n");
         ch = sc.nextInt();
         switch (ch) {
            case 1:
               System.out.println("\nEnter item:\n");
               int item1 = sc.nextInt();
               insert_rear(item1);
               break;
            case 2:
               System.out.println("\nDeleting element from front....\n");
               delete_front();
               break;
            case 3:
               System.out.println("\nEnter item:\n");
               int item2 = sc.nextInt();
               insert_front(item2);
               break;
            case 4:
               System.out.println("\nDeleting element from rear....\n");
               delete_rear();
               break;
            case 5:
               System.out.println("\nDisplaying....\n");
               display();
               break;
            case 6:
               System.out.println("\nBye....\n");
               System.exit(2);
            default:
               System.out.println("\nInvalid Input\n");
         }
      }
   }
}