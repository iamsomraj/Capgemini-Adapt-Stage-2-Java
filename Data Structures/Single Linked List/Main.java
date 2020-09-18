
class Node<X> {
   X value;
   Node<X> next;

   Node(X value) {
      this.value = value;
      this.next = null;
   }

   @Override
   public String toString() {
      return "\tNode value=" + value + "\n";
   }

}

class SLL<X> {
   int length = 0;
   Node<X> head;
   Node<X> tail;

   SLL(X value) {
      this.head = new Node<X>(value);
      this.tail = this.head;
      length++;
   }

   // Adds element at the last
   // Constant time complexity
   void append(X value) {
      if (value == null) {
         return;
      }
      Node<X> newNode = new Node<>(value);
      this.tail.next = newNode;
      this.tail = newNode;
      this.length++;
   }

   // Adds element at the first
   // Constant time compl
   void prepend(X value) {
      if (value == null) {
         return;
      }
      Node<X> newNode = new Node<>(value);
      newNode.next = this.head;
      this.head = newNode;
      this.length++;
   }

   // Adds element at an index
   // Linear time complexity O(n)
   void insert(int index, X value) {
      if (index < 0 || index >= this.length) {
         System.out.println("Cannot insert in " + index);
         return;
      }
      Node<X> newNode = new Node<X>(value);
      Node<X> leader = this.traverseToIndex(index - 1);
      newNode.next = leader.next;
      leader.next = newNode;
      this.length++;
   }

   // Remove element from an index
   // linear time complexity
   void remove(int index) {
      if (this.head == null) {
         System.out.println("Cannot remove : List Empty");
         return;
      }
      if (index < 0 || index >= this.length) {
         System.out.println("Cannot delete in " + index);
         return;
      }
      if (index == 0) {
         System.out.println("Node deleted with value=" + this.head.value);
         this.head = this.head.next;
      } else {
         Node<X> leader = this.traverseToIndex(index - 1);
         System.out.println("Node deleted with value=" + leader.next.value);
         if (index == this.length - 1) {
            leader.next = null;
            this.tail = leader;
         } else {
            leader.next = leader.next.next;
         }
      }
      this.length--;
   }

   // reverses the linked list
   // linear time complexity
   void reverse() {
      if (this.head == null) {
         System.out.println("Cannot reverse : List Empty");
         return;
      }
      // for only one element : there is no change
      if (this.head.next == null) {
         return;
      }

      Node<X> first = this.head;
      this.tail = this.head;
      Node<X> second = this.head.next;
      while (second != null) {
         Node<X> temp = second.next;
         second.next = first;
         first = second;
         second = temp;
      }
      this.head.next = null;
      this.head = first;
      System.out.println((this.toString()));
   }

   // Traverse to index
   // Linear time complexity
   Node<X> traverseToIndex(int index) {
      Node<X> leader = this.head;
      int iter = 0;
      while (iter != index) {
         leader = leader.next;
         iter++;
      }
      return leader;
   }

   @Override
   public String toString() {
      Node<X> leader = this.head;
      String result = "\nSLL\nhead: " + head + "length: " + length + "\ntail: " + tail + "\n";
      result += "List:\n";
      while (leader != null) {
         result += leader;
         leader = leader.next;
      }
      return result;
   }

}

class Main {
   public static void main(String[] args) {
      SLL<String> singleLinkedList = new SLL<>("Mango");
      singleLinkedList.prepend("apple");
      singleLinkedList.append("orange");
      singleLinkedList.append("choco");
      System.out.println(singleLinkedList);
      singleLinkedList.insert(2, "pineapple");
      System.out.println(singleLinkedList);
      singleLinkedList.remove(2);
      System.out.println(singleLinkedList);
      singleLinkedList.reverse();
      singleLinkedList.remove(0);
      System.out.println(singleLinkedList);

   }
}